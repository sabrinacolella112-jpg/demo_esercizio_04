package com.example.demo_esercizio_04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("/all")
    public List<CarEntity> getAllCar() {
        return carRepository.findAll();
    }

    @PostMapping("/create")
    public CarEntity postCars() {
        CarEntity newCar = new CarEntity("fiat","macchina brutta", CarType.BENZINA, CarColor.NERA);
        carRepository.save(newCar);
        return newCar;
    }

    @GetMapping("/oneCar/{id}")
    public ResponseEntity<CarEntity> getOneCar(@PathVariable Long id) {
        if (existsOnDb(id)) {
            CarEntity carEntity = carRepository.findById(id).get();
            return ResponseEntity.status(200).body(carEntity);
        }
        return ResponseEntity.status(404).body(new CarEntity());
    }

    private boolean existsOnDb(Long id) {
        return carRepository.existsById(id);
    }

    @PutMapping("/putType/{id}/{carType}")
    public ResponseEntity<CarEntity> putTypeCar(@PathVariable Long id, @PathVariable String carType) {
        if (existsOnDb(id)) {
            CarEntity carEntity = carRepository.findById(id).get();
            carEntity.setType(CarType.valueOf(carType));
            carRepository.save(carEntity);
            return ResponseEntity.status(200).body(carEntity);
        }
        return ResponseEntity.status(404).body(new CarEntity());
    }

    @DeleteMapping("/deleteOne/{id}")
    public ResponseEntity<CarEntity> deleteOneCar(@PathVariable Long id) {
        if (existsOnDb(id)) {
            CarEntity carEntity = carRepository.findById(id).get();
            carRepository.deleteById(id);
            return ResponseEntity.status(200).body(carEntity);
        }
        return ResponseEntity.status(404).body(new CarEntity());
    }

    @DeleteMapping("/deleteAll")
    public void deleteOneCar() {
        carRepository.deleteAll();
    }
}

