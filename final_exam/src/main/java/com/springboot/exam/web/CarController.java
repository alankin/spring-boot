package com.springboot.exam.web;

import com.springboot.exam.domain.Car;
import com.springboot.exam.service.CarService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alan on 17/6/2017.
 */
@RestController
@RequestMapping("/cars")
@Api(value = "cars", description = "Operations related to cars")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getCars() {
        return carService.getCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Car addCar(@RequestBody CarRequestDTO carDTO) {
        return carService.addNewCar(carDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Car deleteCar(@PathVariable String id) {
        return carService.deleteCar(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Car updateCar(@PathVariable String id, @RequestBody CarRequestDTO carDTO) {
        return carService.updateCar(id, carDTO);
    }

    public static class CarRequestDTO {
        private String brand;
        private long year;
        private String model;
        private String color;
        private String imageUrl;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public long getYear() {
            return year;
        }

        public void setYear(long year) {
            this.year = year;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
