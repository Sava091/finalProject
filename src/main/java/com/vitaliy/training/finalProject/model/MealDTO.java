package com.vitaliy.training.finalProject.model;

import java.util.Date;

public class MealDTO {
    private Date date;
    private String name;
    private double fat;
    private double protein;
    private double carbohydrate;
    private double caloriesPer100gr;

    public MealDTO(Date date, String productName, double fat, double protein, double carbohydrate, double caloriesPer100gr) {
        this.date = date;
        this.name = productName;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.caloriesPer100gr = caloriesPer100gr;
    }

    public MealDTO() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public double getCaloriesPer100gr() {
        return caloriesPer100gr;
    }

    public void setCaloriesPer100gr(double caloriesPer100gr) {
        this.caloriesPer100gr = caloriesPer100gr;
    }

    @Override
    public String toString() {
        return "MealDTO{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", fat=" + fat +
                ", protein=" + protein +
                ", carbohydrate=" + carbohydrate +
                ", caloriesPer100gr=" + caloriesPer100gr +
                '}';
    }
}
