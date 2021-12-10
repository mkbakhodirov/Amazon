package uz.pdp.library;


public interface BaseService<T, S, L> extends SessionMessage {
    String add(T t);
    String remove(T t);
    String edit(T t);
    T get(String str1, String str2);
    T getByIndex(int index);
    L getList(S s);
    L getList();
    T  check(String username, String password);
    boolean isEmpty();
}
