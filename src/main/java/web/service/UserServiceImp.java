package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao = new UserDaoImp();
    @Override
    public List<User> users() {
        return userDao.users();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
}
