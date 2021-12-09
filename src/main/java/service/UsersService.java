package service;

import model.user.User;
import service.base.BaseService;

import java.util.ArrayList;
import java.util.List;
public class UsersService implements BaseService<User, User, List<User>> {
    User user = new User();
    private List<User> users = new ArrayList<>();

    @Override
    public String add(User user) {
        users.add(user);
        return SUCCESS;
    }

    @Override
    public String remove(User user) {
        user.setActive(false);
        return SUCCESS;
    }

    @Override
    public String edit(User user) {
        return null;
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
    public User check(String username, String password) {
        return user;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
