package service;

import Database.BaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.user.User;
import model.user.UserRole;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UsersService implements BaseService<User, User, List<User>> {
    static File file = new File(BaseUrl.url + "users.json");

    @Override
    public String add(User user) {
        List<User> users = read();
        if (users == null)
            users = new ArrayList<>();
        int res = check(user, users);
        if (res == 1) {
            users.add(user);
            write(file, users);
            return SUCCESS;
        }
        else if (res == -1)
            return INVALID_PHONE;
        else if (res == -2)
            return INVALID_USERNAME;
        return null;
    }

    @Override
    public String remove(User user) {
        user.setActive(false);
        return SUCCESS;
    }

    @Override
    public int check(User user, List<User> users) {
        UserRole role = user.getRole();
        if (role.equals(UserRole.USER)) {
            String phoneNumber = user.getPhoneNumber();
            for (User user1 : users) {
                if (user1.getRole().equals(role) && user1.getPhoneNumber().equals(phoneNumber))
                    return -1;
                if (user1.equals(user))
                    return 0;
            }
        } else {
            String username = user.getUsername();
            for (User user1 : users) {
                if (user1.getRole().equals(role) && user1.getUsername().equals(username))
                    return -2;
                if (user1.equals(user))
                    return 0;
            }
        }
        return 1;
    }

    @Override
    public User getByIndex(int index) {
        return null;
    }

    @Override
    public List<User> getList(User shop) {
        return null;
    }

    @Override
    public List<User> getList() {
        return read();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public User get(String str1, String password) {
        List<User> users = read();
        if (users != null) {
            for (User user: users) {
                try {
                    if (user.getUsername().equals(str1) && user.getPassword().equals(password))
                        return user;
                } catch (Exception e) {
                    if (user.getPhoneNumber().equals(str1) && user.getPassword().equals(password))
                        return user;
                }
            }
        }
        return null;
    }

    public List<User> read() {
        try {
            return new ObjectMapper().readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> getActiveAdminsList() {
        List<User> users = read();
        List<User> admins = new ArrayList<>();
        if (users != null) {
            for (User user : users) {
                if (user.isActive() && user.getRole().equals(UserRole.ADMIN))
                    admins.add(user);
            }
        }
        return admins;
    }

    public List<User> getAdminsList() {
        List<User> users = read();
        List<User> admins = new ArrayList<>();
        if (users != null) {
            for (User user : users) {
                if (user.getRole().equals(UserRole.ADMIN))
                    admins.add(user);
            }
        }
        return admins;
    }
}
