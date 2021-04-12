package com.KudryashevDaniil.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Car {
    private String model;
    private String type;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
