package service;

import Database.BaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Comment;
import model.Product;
import model.user.User;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommentService implements BaseService<Comment, Product, List<Comment>> {
    static File file = new File(BaseUrl.url + "comments.json");

    @Override
    public String add(Comment comment) {
        List<Comment> comments = read();
        if (comments == null)
            comments = new ArrayList<>();
        int res = check(comment, comments);
        if (res == 1) {
            comments.add(comment);
            write(file, comments);
            return SUCCESS;
        }
        return null;
    }

    @Override
    public String remove(Comment comment) {
        return null;
    }

    @Override
    public int check(Comment comment, List<Comment> comments) {
        for (Comment comment1 : comments) {
            if (comment1.equals(comment))
                return 0;
        }
        return 1;
    }

    @Override
    public Comment getByIndex(int index) {
        return null;
    }

    @Override
    public List<Comment> getList(Product product) {
        return null;
    }

    @Override
    public List<Comment> getList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public List<Comment> read() {
        try {
            return new ObjectMapper().readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            return null;
        }
    }
}
