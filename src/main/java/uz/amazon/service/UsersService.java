package uz.amazon.service;
import service.base.BaseService;
import uz.amazon.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UsersService implements BaseService<User, User, List<User>> {
    private List<User> users = new ArrayList<>();

    @Override
    public String add(User user) {
        users.add(user);
    }

    @Override
    public String remove(User user) {
        user.setActive(false);
    }

public class UsersService {

    @Override
    public String edit(User user) {
        return null;
    }

    @Override
    public User get(String str1, String str2) {
        for (User user : users) {
            if (user.isActive()) {
                try {
                    if (user.getPhoneNumber().equals(str1))
                }
            }
        }
    }

    @Override
    public User getByIndex(int index) {
        return null;
    }

    @Override
    public User get(User user) {
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
    public boolean check(String str1) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
