package ru.greenlight.springmvchibernate.dao;

import ru.greenlight.springmvchibernate.models.Car;

import java.util.List;

public interface CarDao {
    List<Car> getAllCars();

    List<Car> getCarsByCount(List<Car> cars, int count);
}
