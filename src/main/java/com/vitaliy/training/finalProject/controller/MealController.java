package com.vitaliy.training.finalProject.controller;

import com.vitaliy.training.finalProject.model.Meal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class MealController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("meals", Collections.singletonList(new Meal()));
        req.getRequestDispatcher("mealView.jsp").forward(req, resp);
    }
}
