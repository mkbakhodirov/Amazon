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
        boolean isSuccess = check(role, users);
        if (isSuccess) {
            User superAdmin = new User(role, username, password);
            add(superAdmin, users);
            write(file, users);
            return SUCCESS;
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

    public boolean check(UserRole role, List<User> users) {
        for (User user : users) {
            if (user.isActive() && user.getRole().equals(role))
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
        return null;
    }

    @Override
    public String remove(UUID id) {
        return null;
    }

    @Override
    public boolean remove(User user, List<User> list) {
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
        return null;
    }

    @Override
    public User get(UUID id) {
        return null;
    }

    @Override
    public User get(UUID id, List<User> list) {
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
    public List<User> getList() {
        return read();
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

    public List<User> getActiveAdmins() {
        List<User> activeAdmins = new ArrayList<>();
        for (User user : getActiveList()) {
            if (user.getRole().equals(UserRole.ADMIN))
                activeAdmins.add(user);
        }
        return activeAdmins;
    }
}