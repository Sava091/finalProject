package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Product;

import java.util.List;

public interface ProductDao {
    boolean create(Product product);
    Product read(Long id);
    boolean update(Product product);
    boolean delete(Product product);
    Product readByName(String login);
    List<Product> findAll();
}
