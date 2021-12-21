package service;

import com.fasterxml.jackson.core.type.TypeReference;
import database.BaseUrl;
import model.user.User;
import model.user.UserRole;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersService implements BaseService<User, List<User>> {
    static File file = new File(BaseUrl.url + "users.json");

    public String add(UserRole role, String phoneNumber, String name, String chatId) {
        List<User> users = read();
        boolean isSuccess = check(chatId, users);
        if (isSuccess) {
            User user = new User(name, role, phoneNumber, chatId);
            add(user, users);
            write(file, users);
            return SUCCESS;
        }
        return "unsuccess";
    }

    public String add(UserRole role, String username, String password) {
        List<User> users = read();
        boolean isSuccess = check(users, username);
        if (isSuccess) {
            User admin = new User(role, username, password);
            add(admin, users);
            write(file, users);
            return SUCCESS;
        }
        else {
            if (role.equals(UserRole.ADMIN))
                return INVALID_USERNAME
        }
        return null;
    }

    @Override
    public void add(User user, List<User> users) {
        users.add(user);
    }

    @Override
    public boolean check(String chatId, List<User> users) {
        for (User user : users) {
            if (user.isActive() && user.getChatId() != null && user.getChatId().equals(chatId))
                return false;
        }
        return true;
    }

    public boolean check(List<User> users, String username) {
        for (User user : users) {
            if (user.isActive() && user.getUsername().equals(username))
                return false;
        }
        return true;
    }

    @Override
    public List<User> read() {
        try {
            return obj.readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public String remove(String uuid) {
        UUID id = UUID.fromString(uuid);
        return remove(id);
    }

    @Override
    public String remove(UUID id) {
        List<User> users = read();
        User user = get(id, users);
        if (user != null) {
            boolean isSuccess = remove(user, users);
            if (isSuccess) {
                write(file, users);
                return SUCCESS;
            }
            else
                return "This user was already removed";
        }
        return "User is not found";
    }

    @Override
    public boolean remove(User user, List<User> users) {
        if (user.isActive()) {
            user.setActive(false);
            return true
        }
        return false;
    }

    @Override
    public String editName(String uuid, String name) {
        return null;
    }

    @Override
    public String editName(UUID id, String name) {
        return null;
    }

    @Override
    public boolean editName(User user, String name) {
        return false;
    }

    @Override
    public User get(String uuid) {
        UUID id = UUID.fromString(uuid);
        return get(id);
    }

    @Override
    public User get(UUID id) {
        List<User> users = read();
        return get(id, users);
    }

    @Override
    public User get(UUID id, List<User> users) {
        for (User user : users) {
            if (user.getId().equals(id))
                return user;
        }
        return null;
    }

    public User get(String username, String password) {
        List<User> users = read();
        for (User user : users) {
            if (user.isActive() && user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    @Override
    public List<User> getActiveList() {
        List<User> activeList = new ArrayList<>();
        for (User user : getList()) {
            if (user.isActive())
                activeList.add(user);
        }
        return activeList;
    }

    public List<User> getAdmins() {
        List<User> admins = new ArrayList<>();
        for (User user : getList()) {
            if (user.getRole().equals(UserRole.ADMIN))
                admins.add(user);
        }
        return admins;
    }

    public List<User> getActiveAdmins() {
        List<User> activeAdmins = new ArrayList<>();
        for (User user : getAdmins()) {
            if (user.isActive())
                activeAdmins.add(user);
        }
        return activeAdmins;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (User user : getList()) {
            if (user.getRole().equals(UserRole.USER))
                users.add(user);
        }
        return users;
    }

    public List<User> getActiveUsers() {
        List<User> activeUsers = new ArrayList<>();
        for (User user : getActiveList()) {
            if (user.getRole().equals(UserRole.USER))
                activeUsers.add(user);
        }
        return activeUsers;
    }


}