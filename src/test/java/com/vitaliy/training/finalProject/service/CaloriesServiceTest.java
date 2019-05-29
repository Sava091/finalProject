package com.vitaliy.training.finalProject.service;

import com.vitaliy.training.finalProject.model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CaloriesServiceTest {
    private CaloriesService caloriesService;

    @Before
    public void setUp() {
        caloriesService = new CaloriesService();
    }

    @Test
    public void calcCaloriesOverhead() {
        Client client = new Client(1L, "Vitaliy", "pass", 21, 180, 70, Activity.MEDIUM, Sex.MAN, 1L, 1L);
        Product product1 = new Product(1l, "a", 1, 2, 3, 100);
        Product product2 = new Product(2l, "b", 2, 4, 2,200);
        Product product3 = new Product(3l, "c", 4, 5, 4,300);
        List<Meal> meal = Arrays.asList(
                new Meal(3L, product1, 10, new Date(),1l),
                new Meal(2L, product2, 10, new Date(),2L),
                new Meal(1L, product3, 10, new Date(),3L)
                );
        double caloriesOverhead = caloriesService.calcCaloriesOverhead(client, new Date(), meal);
        assertEquals(3255, (int) caloriesOverhead);
    }
}