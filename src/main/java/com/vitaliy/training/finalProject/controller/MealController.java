package com.vitaliy.training.finalProject.controller;

import com.vitaliy.training.finalProject.dao.*;
import com.vitaliy.training.finalProject.model.Client;
import com.vitaliy.training.finalProject.model.Meal;
import com.vitaliy.training.finalProject.model.MealDTO;
import com.vitaliy.training.finalProject.model.Product;
import com.vitaliy.training.finalProject.service.CaloriesService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.vitaliy.training.finalProject.controller.LoginFilter.USER_ID;

public class MealController extends HttpServlet {
    private static Logger logger = Logger.getLogger(MealController.class);
    public static final int PAGE_SIZE = 10;
    private static MealsDao mealsDao = MealsDaoImpl.getInstance();
    private static ProductDao productDao = ProductDaoImpl.getInstance();
    private static ClientDao clientDao = ClientDaoImpl.getInstance();
    private static CaloriesService caloriesService = CaloriesService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Meal controller");

        setAttributes(req);
        req.getRequestDispatcher("/mealView.jsp").forward(req, resp);
    }

    private void setAttributes(HttpServletRequest req) {
        String pageStr = req.getParameter("page");
        int page = 0;
        try {
            page = Integer.parseInt(pageStr);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        Client client = clientDao.read(userId);

        List<MealDTO> meals = mealsDao.findAll(client.getId(), page, PAGE_SIZE).stream()
                .map(m -> new MealDTO(m.getDate(), m.getProduct().getName(), m.getProduct().getFat(), m.getProduct().getProtein(), m.getProduct().getCarbohydrate(), m.getProduct().getCaloriesPer100gr() * m.getQuantityOf100grPortions()))
                .collect(Collectors.toList());

        int size = mealsDao.findAll(userId).size();

        if (page <= size / PAGE_SIZE) {
            req.setAttribute("page", page);
        }


        int pages = size / PAGE_SIZE + ((size % PAGE_SIZE == 0) ? 0 : 1);
        req.setAttribute("pagesCount", pages);
        req.setAttribute("meals", meals);
        req.setAttribute("products", productDao.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Meal controller save");
        String productIdStr = req.getParameter("productId");
        String quantityStr = req.getParameter("quantity");
        String dateStr = req.getParameter("date");
        long productId = Long.parseLong(productIdStr);
        int quantity = Integer.parseInt(quantityStr);
        Product product = productDao.read(productId);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        if (userId != null) {
            Meal meal = new Meal(0L, product, quantity, date, userId);
            mealsDao.create(meal);
        }

        setAttributes(req);

        Client client = clientDao.read(userId);
        double calories = caloriesService.calcCaloriesOverhead(client, date, mealsDao.findAll(client.getId()));
        req.setAttribute("calories", calories);

        req.getRequestDispatcher("/mealView.jsp").forward(req, resp);
    }
}
