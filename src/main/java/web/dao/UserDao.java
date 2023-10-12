package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> users();
    void add(User user);
    User edit(User user);
    void delete();
    User show(long id);
}
