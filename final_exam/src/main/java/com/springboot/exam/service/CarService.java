package com.springboot.exam.service;

import com.springboot.exam.domain.Car;
import com.springboot.exam.repository.CarRepository;
import com.springboot.exam.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan on 17/6/2017.
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car addNewCar(CarController.CarRequestDTO carRequestDTO) {
        Car car = new Car();
        car.setBrand(carRequestDTO.getBrand());
        car.setColor(carRequestDTO.getColor());
        car.setImageUrl(carRequestDTO.getImageUrl());
        car.setModel(carRequestDTO.getModel());
        car.setYear(carRequestDTO.getYear());

        carRepository.save(car);

        return car;
    }

    public Car deleteCar(String id) {
        Car car = carRepository.findOne(id);

        carRepository.delete(car);

        return car;
    }

    public Car updateCar(String id, CarController.CarRequestDTO carRequestDTO) {
        Car car = new Car();
        car.setBrand(carRequestDTO.getBrand());
        car.setColor(carRequestDTO.getColor());
        car.setImageUrl(carRequestDTO.getImageUrl());
        car.setModel(carRequestDTO.getModel());
        car.setYear(carRequestDTO.getYear());
        car.setId(id);

        carRepository.save(car);

        return car;
    }
}
