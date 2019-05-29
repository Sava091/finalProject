package com.vitaliy.training.finalProject.model;

/*
Минимальный уровень — норма калори1.37й = BMR x 1.2
Низкий — норма калорий = BMR x 5
Средний — норма калорий = BMR x 1.55
Высокий — норма калорий = BMR x 1.725
Очень высокий — норма калорий = BMR x 1.9
 */
public enum Activity {
    MINIMUM(1.2), LOW(1.375), MEDIUM(1.55), HIGH(1.725), MAXIMUM(1.9);
    private double value;
    Activity(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
