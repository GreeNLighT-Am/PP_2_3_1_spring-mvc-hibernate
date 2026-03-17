package ru.greenlight.springmvchibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.greenlight.springmvchibernate.dao.CarDao;
import ru.greenlight.springmvchibernate.models.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final CarDao carDao;

    @Autowired
    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public List<Car> getCarsByCount(List<Car> cars, int count) {
        return carDao.getCarsByCount(cars, count);
    }
}