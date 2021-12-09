package service.base;

import response.Response;

public interface BaseService<T, S, L> extends Response {
    void add(T t);
    void remove(T t);
    String edit(T t);
    T get(String str1, String str2);
    T getByIndex(int index);
    T get(S s);
    L getList(S s);
    L getList();
    boolean check(String str1);
    boolean isEmpty();
}
