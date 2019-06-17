package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Client;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClientDaoImplTest {
    private ClientDao clientDao;

    @Before
    public void setUp() {
        clientDao = new ClientDaoImpl("jdbc:mysql://localhost:3306/fitnesstracking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "root");
    }

    @Test
    public void findAll() {
        List<Client> clients = clientDao.findAll();
        System.out.println(clients);
        assertNotNull(clients);
    }
}