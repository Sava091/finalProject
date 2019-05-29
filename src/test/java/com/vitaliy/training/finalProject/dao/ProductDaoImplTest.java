package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoImplTest {
    ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        productDao = new ProductDaoImpl ("jdbc:mysql://localhost:3306/fitnesstracking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "root");
    }

    @Test
    public void findAll() {
        List<Product> products = productDao.findAll();
        System.out.println(products);
        assertNotNull(products);
    }
}