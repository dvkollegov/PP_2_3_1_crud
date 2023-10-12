package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

//@Component
@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private EntityManagerFactory emf;

//    @PersistenceContext
//    private EntityManager entityManager;

    private final List<Car> cars = new ArrayList<>();

    {
        cars.add( new Car("Car-1", "Mod-1", 100_000));
        cars.add( new Car("Car-2", "Mod-2", 150_000));
        cars.add( new Car("Car-3", "Mod-3", 200_000));
        cars.add( new Car("Car-4", "Mod-4", 250_000));
        cars.add( new Car("Car-5", "Mod-5", 300_000));
    }


    @Override
    public void add() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        User user = new User();
        user.setName("Name");
        user.setLastName("LastName");
        user.setAge(25);
        user.setEmail("asdf@mail.ru");

        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Car> carList() {
        return cars;
    }

    @Override
    public List<Car> carShow(int count) {
        List<Car> rsl = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rsl.add(cars.get(i));
        }
        return rsl;
    }
}
