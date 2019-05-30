package com.vitaliy.training.finalProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vitaliy.training.finalProject.model.Activity;
import com.vitaliy.training.finalProject.model.Client;
import com.vitaliy.training.finalProject.model.Sex;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ArrayList;

public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {
    private static final ClientDao instance = new ClientDaoImpl("jdbc:mysql://localhost:3306/fitnesstracking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            "root", "root");
    private static Logger logger = Logger.getLogger(ClientDaoImpl.class);
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String HEIGHT = "height";
    public static final String WEIGHT = "weight";
    public static final String ACTIVITY = "activity";
    public static final String SEX = "sex";
    public static final String PASSWORD = "password";
    public static final String COEF_ID = "coef_id";
    public static final String CLIENT_MEAL_ID = "client_meal_id";
    public static ClientDao getInstance() {
        return instance;
    }
    public ClientDaoImpl(String uri, String userName, String password) {
        super(uri, userName, password);
    }

    @Override
    public boolean create(Client client) {
        logger.info("Client create");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql = "INSERT INTO clients (id, name, password, age, height, weight, activity, sex, coef_id, client_meal_id) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, client.getId());
            statement.setString(2, client.getName());
            statement.setString(3, client.getPassword());
            statement.setLong(4, client.getAge());
            statement.setDouble(5, client.getHeight());
            statement.setDouble(6, client.getWeight());
            statement.setString(7, client.getActivity().name());
            statement.setString(8, client.getSex().name());
            statement.setLong(9, client.getCoefId());
            statement.setLong(9, client.getClientMealId());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public Client read(Long id) {
        logger.info("Client read");
        Mapper<Client> clientMapper = rs -> {
            try {
                if (rs.next()) {
                    final Client client = new Client();
                    client.setId(rs.getLong(ID));
                    client.setName(rs.getString(NAME));
                    client.setPassword(rs.getString(PASSWORD));
                    client.setAge(rs.getInt(AGE));
                    client.setHeight(rs.getDouble(HEIGHT));
                    client.setWeight(rs.getDouble(WEIGHT));
                    client.setActivity(Activity.valueOf(rs.getString(ACTIVITY)));
                    client.setSex(Sex.valueOf(rs.getString(SEX)));
                    client.setCoefId(rs.getLong(COEF_ID));
                    client.setClientMealId(rs.getLong(CLIENT_MEAL_ID));
                    return client;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new Client();
        };
        return super.read("SELECT * FROM clients where id = " + id, clientMapper);
    }

    @Override
    public boolean update(Client client) {
        logger.info("Client update");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql = "UPDATE clients SET name=?, password=?, age=?, height=?, weight=?, activity=?, sex=?, coef_id=?, client_meal_id=?" +
                    " WHERE id =? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, client.getName());
            statement.setString(2, client.getPassword());
            statement.setLong(3, client.getAge());
            statement.setDouble(4, client.getHeight());
            statement.setDouble(5, client.getWeight());
            statement.setString(6, client.getActivity().name());
            statement.setString(7, client.getSex().name());
            statement.setLong(8, client.getCoefId());
            statement.setLong(9, client.getClientMealId());
            statement.setLong(10, client.getId());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public boolean delete(Client client) {
        logger.info("Client delete");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql = "DELETE FROM clients WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, client.getId());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public Client readByName(String name) {
        logger.info("Client readbyName");
        Mapper<Client> clientMapper = rs -> {
            try {
                if (rs.next()) {
                    final Client client = new Client();
                    client.setId(rs.getLong(ID));
                    client.setName(rs.getString(NAME));
                    client.setPassword(rs.getString(PASSWORD));
                    client.setAge(rs.getInt(AGE));
                    client.setHeight(rs.getDouble(HEIGHT));
                    client.setWeight(rs.getDouble(WEIGHT));
                    client.setActivity(Activity.valueOf(rs.getString(ACTIVITY)));
                    client.setSex(Sex.valueOf(rs.getString(SEX)));
                    client.setCoefId(rs.getLong(COEF_ID));
                    client.setClientMealId(rs.getLong(CLIENT_MEAL_ID));
                    return client;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new Client();
        };
        return super.read("SELECT * FROM clients where name = '" + name + "'", clientMapper);
    }

    public List<Client> findAll() {
        logger.info("Client findAll");
        Mapper<List<Client>> clientMapper = rs -> {
            List<Client> clients = new ArrayList<>();
            try {
                while (rs.next()) {
                    final Client client = new Client();
                    client.setId(rs.getLong(ID));
                    client.setName(rs.getString(NAME));
                    client.setPassword(rs.getString(PASSWORD));
                    client.setAge(rs.getInt(AGE));
                    client.setHeight(rs.getDouble(HEIGHT));
                    client.setWeight(rs.getDouble(WEIGHT));
                    client.setActivity(Activity.valueOf(rs.getString(ACTIVITY)));
                    client.setSex(Sex.valueOf(rs.getString(SEX)));
                    client.setCoefId(rs.getLong(COEF_ID));
                    client.setClientMealId(rs.getLong(CLIENT_MEAL_ID));
                    clients.add(client);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return clients;
        };
        return super.findAll("SELECT * FROM clients", clientMapper);

    }
}
