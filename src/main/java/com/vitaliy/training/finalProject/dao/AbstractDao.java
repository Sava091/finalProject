package com.vitaliy.training.finalProject.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.List;

public class AbstractDao<T> {
    private String uri;
    private String userName;
    private String password;
    private static BasicDataSource dataSource;

    public AbstractDao(String uri, String userName, String password) {
        this.uri = uri;
        this.userName = userName;
        this.password = password;
    }

    protected final Connection getConnection() throws SQLException {
        return getDataSource(this.uri, this.userName, this.password).getConnection();
    }

    private static BasicDataSource getDataSource (String uri, String userName, String password) {

        if (dataSource == null) {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl(uri);
            ds.setUsername(userName);
            ds.setPassword(password);


            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }
        return dataSource;
    }

    public T read(String query, Mapper<T> mapper) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            return resultSet == null ? null : mapper.map(resultSet);
        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return null;
    }

    public List<T> findAll(String query, Mapper<List<T>> mapper) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            return resultSet == null ? null : mapper.map(resultSet);
        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return null;
    }

    protected void closeQuietly(final Connection connection,
                                final Statement statement,
                                final ResultSet resultSet) {
        if (null != resultSet)
            try {
                resultSet.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            } // or log properly

        if (null != statement)
            try {
                statement.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            } // or log properly

        if (null != connection)
            try {
                connection.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            } // or log properly
    }
}
