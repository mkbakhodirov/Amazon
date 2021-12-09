package service.base;


import model.response.Response;

public interface BaseService<T, S, L> extends Response {
    String add(T t);
    String remove(T t);
    String edit(T t);
    T get(String str1, String str2);
    T getByIndex(int index);
    L getList(S s);
    L getList();
    boolean check(String str1);
    boolean isEmpty();
}
