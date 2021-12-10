package uz.pdp.library;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static uz.pdp.library.SessionMessage.NOT_FOUND;
import static uz.pdp.library.SessionMessage.WRITED;
import static uz.pdp.library.Util.*;

public class WriteJson<T> {


    public void writeJson(String file, List<T> lists) {
        try (Writer writer = new FileWriter(file)) {
            Gson gson = new Gson();
            String s = gson.toJson(lists);
            writer.write(s);
            print(BLUE, WRITED);
        } catch (IOException e) {
            print(RED, NOT_FOUND);
        }
    }

}
