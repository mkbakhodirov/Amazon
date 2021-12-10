package uz.pdp.library;

import uz.pdp.model.user.User;

public interface CrudRepository<T> {

    void create(User user);

    void read(User user);

    void update(User user);

    void delete(User user);

    T findById();

    T filter(String object);

    void writeJson();

    void crudMenu(User user);

}
