package ru.greenlight.springmvchibernate.dao;

import org.springframework.stereotype.Repository;
import ru.greenlight.springmvchibernate.models.Car;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    @Override
    public List<Car> getAllCars() {
        return List.of(
                new Car("Corolla", "E150", "Silver"),
                new Car("Audi", "A8", "Black"),
                new Car("Subaru", "Impreza", "Blue"),
                new Car("Toyota", "Camry", "Black"),
                new Car("Toyota", "Prado", "Black")
        );
    }

    @Override
    public List<Car> getCarsByCount(List<Car> cars, int count) {
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
