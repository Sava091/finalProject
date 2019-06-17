package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Coefficient;
import com.vitaliy.training.finalProject.dao.CoefficientDao;
import com.vitaliy.training.finalProject.dao.СoefficientDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class СoefficientDaoImplTest {
    private CoefficientDao coefficientDao;

    @Before
    public void setUp() {
        coefficientDao = new СoefficientDaoImpl("jdbc:mysql://localhost:3306/fitnesstracking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "root");
    }
    @Test
    public void findAll() {
        List<Coefficient> coefficients = coefficientDao.findAll();
        System.out.println(coefficients);
        assertFalse(coefficients.isEmpty());

    }
}