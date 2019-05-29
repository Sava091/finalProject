package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Client;

import java.util.List;

public interface ClientDao {
    boolean create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete(Client client);
    Client readByName(String login);
    List<Client> findAll();
}
