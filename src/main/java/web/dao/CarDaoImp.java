package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoImp implements CarDao {
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add( new Car("Car-1", "Mod-1", 100_000));
        cars.add( new Car("Car-2", "Mod-2", 150_000));
        cars.add( new Car("Car-3", "Mod-3", 200_000));
        cars.add( new Car("Car-4", "Mod-4", 250_000));
        cars.add( new Car("Car-5", "Mod-5", 300_000));
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
