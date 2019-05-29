package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Meal;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MealsDaoImplTest {

    MealsDao mealsDao;
    @Before
    public void setUp() throws Exception {
        mealsDao = new MealsDaoImpl ("jdbc:mysql://localhost:3306/fitnesstracking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "root");
    }

    @Test
    public void testFindAll() {
        List<Meal> meals = mealsDao.findAll();
        System.out.println(meals);
        assertFalse(meals.isEmpty());
    }

    @Test
    public void testFind() {
        Meal meal = mealsDao.read(1L);
        System.out.println(meal);
        assertNotNull(meal);
    }
}