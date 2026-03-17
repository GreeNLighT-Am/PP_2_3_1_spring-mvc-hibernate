package ru.greenlight.springmvchibernate.service;

import ru.greenlight.springmvchibernate.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    List<Car> getCarsByCount(List<Car> cars, int count);
}