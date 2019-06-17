package com.vitaliy.training.finalProject.controller;

import com.vitaliy.training.finalProject.dao.ProductDao;
import com.vitaliy.training.finalProject.dao.ProductDaoImpl;
import com.vitaliy.training.finalProject.model.Meal;
import com.vitaliy.training.finalProject.model.Product;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class ProductController extends HttpServlet {
    private static Logger logger = Logger.getLogger(ProductController.class);
    private static ProductDao productDao = ProductDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Product controller");
        req.setAttribute("meals", Collections.singletonList(new Meal()));
        String name = req.getParameter("description");
        String fatStr = req.getParameter("fat");
        String proteinStr = req.getParameter("protein");
        String carbohydrateStr = req.getParameter("carbohydrate");
        String caloriesStr = req.getParameter("calories");
        double fat = Double.parseDouble(fatStr);
        double protein = Double.parseDouble(proteinStr);
        double carbohydrate = Double.parseDouble(carbohydrateStr);
        double calories = Double.parseDouble(caloriesStr);
        Product product = new Product(0L, name, fat, protein, carbohydrate, calories);
        productDao.create(product);
        req.getRequestDispatcher("/meal").forward(req, resp);
    }
}
