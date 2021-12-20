package service.base;


import com.fasterxml.jackson.databind.ObjectMapper;
import database.BaseUrl;
import model.response.Response;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface BaseService<T, L> extends Response {
    static ObjectMapper obj = new ObjectMapper();

    void add(T t, L list);

    String remove(String uuid);
    String remove(UUID id);
    boolean remove(T t, L list);

    String editName(String uuid, String name);
    String editName(UUID id, String name);
    boolean editName(T t, String name);

    boolean check(String str, L list);

    T get(String uuid);
    T get(UUID id);
    T get(UUID id, L list);

    L read();
    L getActiveList();


    default void write(File file, L list) {
        try {
            obj.writerWithDefaultPrettyPrinter().writeValue(file, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default L getList() {
        return read();
    }
}