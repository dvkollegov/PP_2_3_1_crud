package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDaoImp;

    @Autowired
    public CarServiceImpl(CarDao carDaoImp) {
        this.carDaoImp = carDaoImp;
    }

    @Override
    public List<Car> carShow(int count) {
        if (count > 5) {
            return carDaoImp.carList();
        }
        return carDaoImp.carShow(count);
    }
}
