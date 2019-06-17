package com.vitaliy.training.finalProject.controller;

import com.vitaliy.training.finalProject.dao.ClientDao;
import com.vitaliy.training.finalProject.dao.ClientDaoImpl;
import com.vitaliy.training.finalProject.model.Activity;
import com.vitaliy.training.finalProject.model.Client;
import com.vitaliy.training.finalProject.model.Sex;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class ClientController extends HttpServlet {
    private static Logger logger = Logger.getLogger(com.vitaliy.training.finalProject.controller.ClientController.class);
    private static ClientDao clientDao = ClientDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Client controller");
        req.setAttribute("clients", Collections.singletonList(new Client()));
        String name = req.getParameter("name");
        String pass = req.getParameter("password");
        String ageStr = req.getParameter("InputAge");
        String heightStr = req.getParameter("InputHeight");
        String weightStr = req.getParameter("InputWeight");
        String activityStr = req.getParameter("FormControlActivity");
        String sexStr = req.getParameter("sexradio");
        double age = Double.parseDouble(ageStr);
        double height = Double.parseDouble(heightStr);
        double weight = Double.parseDouble(weightStr);
        Activity activity = Activity.valueOf(req.getParameter(activityStr));
        Sex sex = Sex.valueOf(req.getParameter(sexStr));
        Client client = new Client(0L, name, pass, (int) age, height, weight, activity, sex, 0L, 0L);
        clientDao.create(client);
        req.getRequestDispatcher("/mealView.jsp").forward(req, resp);
    }
}

