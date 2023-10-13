package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public List<User> users() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void add(User user) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void edit(User user) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUser(long id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(User.class, id);
    }
}
