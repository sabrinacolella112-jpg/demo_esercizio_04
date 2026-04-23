package com.example.demo_esercizio_04;

import jakarta.persistence.*;

@Entity
@Table(name= "Car")

public class CarEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;
@Column(name = "modelName")
private String modelName;
@Column(name = "description")
private String description;
@Column(name = "type")
@Enumerated(EnumType.ORDINAL)
private CarType type;
@Column(name = "color")
@Enumerated(EnumType.STRING)
private CarColor color;

public CarEntity(){}

    public CarEntity(String modelName, String description, CarType type, CarColor color) {
        this.modelName = modelName;
        this.description = description;
        this.type = type;
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }
}
