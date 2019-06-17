package com.vitaliy.training.finalProject.model;

import java.util.Date;

public class Meal {
    private Long id;
    private Product product;
    private double quantityOf100grPortions;
    private Date date;
    private Long mealClientId;

    public Meal(Long id, Product product, double quantityOf100grPortions, Date date, Long mealClientId) {
        this.id = id;
        this.product = product;
        this.quantityOf100grPortions = quantityOf100grPortions;
        this.date = date;
        this.mealClientId = mealClientId;
    }

    public Meal() {
    }

    public Long getMealClientId() {
        return mealClientId;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantityOf100grPortions() {
        return quantityOf100grPortions;
    }

    public Date getDate() {
        return date;
    }

    public void setMealClientId(Long mealClientId) {
        this.mealClientId = mealClientId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantityOf100grPortions(double quantityOf100grPortions) {
        this.quantityOf100grPortions = quantityOf100grPortions;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", product=" + product +
                ", quantityOf100grPortions=" + quantityOf100grPortions +
                ", date=" + date +
                ", mealClientId=" + mealClientId +
                '}';
    }
}
