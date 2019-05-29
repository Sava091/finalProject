package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Meal;

import java.util.List;

public interface MealsDao {
    boolean create(Meal meal);
    Meal read(Long id);
    boolean update(Meal meal);
    boolean delete(Meal meal);
    List<Meal> findAll();
}
