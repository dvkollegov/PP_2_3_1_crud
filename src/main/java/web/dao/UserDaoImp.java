package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public List<User> users() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> resultList = entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    @Override
    public void add(User user) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public User show(long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        User result = entityManager
                .createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        return result;
    }
}
