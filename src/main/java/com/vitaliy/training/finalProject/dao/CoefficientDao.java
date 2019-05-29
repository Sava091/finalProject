package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Coefficient;

import java.util.List;

public interface CoefficientDao {
    boolean create(Coefficient сoefficient);
    Coefficient read(Long id);
    boolean update(Coefficient сoefficient);
    boolean delete(Coefficient сoefficient);
    Coefficient readBySex(String sex);
    List<Coefficient> findAll();
}
