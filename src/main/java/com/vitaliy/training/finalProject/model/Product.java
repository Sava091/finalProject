package com.vitaliy.training.finalProject.model;

public class Product {
    private Long id;
    private String name;
    private double fat;
    private double protein;
    private double carbohydrate;
    private double caloriesPer100gr;

    public Product() {
    }

    public Product(Long id, String name, double fat, double protein, double carbohydrate, double caloriesPer100gr) {
        this.id = id;
        this.name = name;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.caloriesPer100gr = caloriesPer100gr;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public double getCaloriesPer100gr() {
        return caloriesPer100gr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setCaloriesPer100gr(double caloriesPer100gr) {
        this.caloriesPer100gr = caloriesPer100gr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fat=" + fat +
                ", protein=" + protein +
                ", carbohydrate=" + carbohydrate +
                ", caloriesPer100gr=" + caloriesPer100gr +
                '}';
    }
}

