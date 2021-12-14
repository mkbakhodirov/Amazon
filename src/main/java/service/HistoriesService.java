package service;

import Database.BaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;
import model.history.BaseHistory;
import model.user.User;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HistoriesService implements BaseService<BaseHistory, User, List<BaseHistory>> {
    static File file = new File(BaseUrl.url + "histories.json");

    @Override
    public String add(BaseHistory baseHistory) {
        List<BaseHistory> histories = read();
        if (histories == null)
            histories = new ArrayList<>();
        int res = check(baseHistory, histories);
        if (res == 1) {
            histories.add(baseHistory);
            write(file, histories);
            return SUCCESS;
        }
        return null;
    }

    @Override
    public String remove(BaseHistory baseHistory) {
        return null;
    }

    @Override
    public int check(BaseHistory baseHistory, List<BaseHistory> histories) {
        for (BaseHistory baseHistory1 : histories) {
            if (baseHistory1.equals(baseHistory))
                return 0;
        }
        return 1;
    }

    @Override
    public BaseHistory getByIndex(int index) {
        return null;
    }

    @Override
    public List<BaseHistory> getList(User user) {
        return null;
    }

    @Override
    public List<BaseHistory> getList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public List<BaseHistory> read() {
        try {
            return new ObjectMapper().readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            return null;
        }
    }
}
