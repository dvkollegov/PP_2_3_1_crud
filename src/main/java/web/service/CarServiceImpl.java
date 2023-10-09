package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.dao.CarDaoImp;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarDao carDaoImp = new CarDaoImp();

    @Override
    public List<Car> carList() {
        return carDaoImp.carList();
    }

    @Override
    public List<Car> carShow(int count) {
        return carDaoImp.carShow(count);
    }
}
