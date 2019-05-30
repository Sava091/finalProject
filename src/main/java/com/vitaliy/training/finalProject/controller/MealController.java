package com.vitaliy.training.finalProject.controller;

import com.vitaliy.training.finalProject.model.Meal;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class MealController extends HttpServlet {
    private static Logger logger = Logger.getLogger(MealController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Meal controller");
        req.setAttribute("meals", Collections.singletonList(new Meal()));
        req.getRequestDispatcher("mealView.jsp").forward(req, resp);
    }
}
