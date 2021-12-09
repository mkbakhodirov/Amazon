package uz.amazon.service;

import uz.amazon.response.Response;

    public interface BaseService<T, S, L> extends Response {
        String add(T t);
        T get(String str1, String str2);
        T getByIndex(int index);
        T get(S s);
        boolean check(String str1);
        boolean isEmpty();
    }


