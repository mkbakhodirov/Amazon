package service;

import Database.BaseUrl;
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
        List<User> users = read(file);
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
        return null;
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
    public User get(String str1, String str2) {
        return null;
    }

    @Override
    public User getByIndex(int index) {
        return null;
    }

    @Override
    public List<User> getList(User user) {
        return null;
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


}
