package service.base;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.response.Response;

import java.io.File;

public interface BaseService<T, S, L> extends Response {
    String add(T t);
    String remove(T t);
    int check(T t, L list);
    T getByIndex(int index);
    L getList(S s);
    L getList();
    boolean isEmpty();

    default L read(File file) {
        try {
            return new ObjectMapper().readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            return null;
        }
    }

    default void write(File file, L list) {
        try {
            new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(file, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
