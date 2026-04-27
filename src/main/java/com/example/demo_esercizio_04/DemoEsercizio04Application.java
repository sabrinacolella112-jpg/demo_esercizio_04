package com.example.demo_esercizio_04;

import com.example.demo_esercizio_04.CarColor;
import com.example.demo_esercizio_04.CarEntity;
import com.example.demo_esercizio_04.CarRepository;
import com.example.demo_esercizio_04.CarType;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class DemoEsercizio04Application implements ApplicationRunner {

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoEsercizio04Application.class, args);
    }


    public void initDb() {
        CarEntity newCar = new CarEntity("fiat", "macchina brutta", CarType.BENZINA, CarColor.NERA);
        carRepository.save(newCar);
        CarEntity newCar2 = new CarEntity("dacia", "macchina bella", CarType.ELETTRICA, CarColor.BIANCA);
        carRepository.save(newCar2);
        CarEntity newCar3 = new CarEntity("ferrari", "macchina brutta", CarType.BENZINA, CarColor.NERA);
        carRepository.save(newCar3);
        CarEntity newCar4 = new CarEntity("lamborghini", "macchina brutta", CarType.ELETTRICA, CarColor.BIANCA);
        carRepository.save(newCar4);


    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        initDb();
    }

}