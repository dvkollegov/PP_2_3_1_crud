package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> users();
    void add(User user);
    void edit(User user);
    void delete(long id);
    User getUser(long id);
}
