package ru.greenlight.springmvchibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.greenlight.springmvchibernate.models.Car;
import ru.greenlight.springmvchibernate.service.CarService;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {

        List<Car> cars = carService.getAllCars();

        if (count != null) {
            if (count < 0 || count == 0) {
                model.addAttribute("error", "Ошибка: значение count не может быть 0 или отрицательным.");
            } else {
                model.addAttribute("cars", carService.getCarsByCount(cars, count));
            }
        } else {
            model.addAttribute("cars", cars);
        }

        return "cars";
    }
}