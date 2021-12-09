package repository;

import response.Response;
import uz.pdp.response.Response;

public interface BaseRepository<T, S, M> extends Response {
    String  add(T t, M m);

    String remove(T t);

    T edit(T t);

    S getList();

    T check(T t);

}
