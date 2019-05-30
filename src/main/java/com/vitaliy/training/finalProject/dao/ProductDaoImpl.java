package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Product;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
    private static final ProductDao instance = new ProductDaoImpl("jdbc:mysql://localhost:3306/fitnesstracking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            "root", "root");
    private static Logger logger = Logger.getLogger(ProductDaoImpl.class);
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String FAT = "fat";
    public static final String PROTEIN = "protein";
    public static final String CARBOHYDRATE = "carbohydrate";
    public static final String CALORIES_PER_100_GR = "caloriesPer100gr";

    public static ProductDao getInstance() {
        return instance;
    }

    public ProductDaoImpl(String uri, String userName, String password) {
        super(uri, userName, password);
    }

    @Override
    public boolean create(Product product) {
        logger.info("Product create");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql1 = "INSERT INTO products (id, name, fat, protein, carbohydrate, caloriesPer100gr) " +
                    "VALUES(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql1);
            statement.setLong(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getFat());
            statement.setDouble(4, product.getProtein());
            statement.setDouble(5, product.getCarbohydrate());
            statement.setDouble(6, product.getCaloriesPer100gr());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public Product read(Long id) {
        logger.info("Product read");
        Mapper<Product> productMapper = rs -> {
            try {
                if (rs.next()) {
                    final Product product = new Product();
                    product.setId(rs.getLong(ID));
                    product.setName(rs.getString(NAME));
                    product.setFat(rs.getDouble(FAT));
                    product.setProtein(rs.getDouble(PROTEIN));
                    product.setCarbohydrate(rs.getDouble(CARBOHYDRATE));
                    product.setCaloriesPer100gr(rs.getDouble(CALORIES_PER_100_GR));
                    return product;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new Product();
        };
        return super.read("SELECT * FROM products where id = " + id, productMapper);
    }

    @Override
    public boolean update(Product product) {
        logger.info("Product update");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql2 = "UPDATE products SET name=?, fat=?, protein=?, carbohydrate=?, caloriesPer100gr=? " +
                    "WHERE id =?";
            statement = connection.prepareStatement(sql2);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getFat());
            statement.setDouble(3, product.getProtein());
            statement.setDouble(4, product.getCarbohydrate());
            statement.setDouble(5, product.getCaloriesPer100gr());
            statement.setLong(6, product.getId());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public boolean delete(Product product) {
        logger.info("Product delete");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql3 = "DELETE FROM products WHERE id=?";
            statement = connection.prepareStatement(sql3);
            statement.setLong(1, product.getId());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public Product readByName(String name) {
        logger.info("Product readByName");
        Mapper<Product> productMapper = rs -> {
            try {
                if (rs.next()) {
                    final Product product = new Product();
                    product.setId(rs.getLong(ID));
                    product.setName(rs.getString(NAME));
                    product.setFat(rs.getDouble(FAT));
                    product.setProtein(rs.getDouble(PROTEIN));
                    product.setCarbohydrate(rs.getDouble(CARBOHYDRATE));
                    product.setCaloriesPer100gr(rs.getDouble(CALORIES_PER_100_GR));
                    return product;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new Product();
        };
        return super.read("SELECT * FROM products where name = " + name, productMapper);
    }
    @Override
    public List<Product> findAll() {
        logger.info("Product findAll");
        Mapper<List<Product>> productMapper = rs -> {
            List<Product> products = new ArrayList<>();
            try {
                while (rs.next()) {
                    final Product product = new Product();
                    product.setId(rs.getLong(ID));
                    product.setName(rs.getString(NAME));
                    product.setFat(rs.getDouble(FAT));
                    product.setProtein(rs.getDouble(PROTEIN));
                    product.setCarbohydrate(rs.getDouble(CARBOHYDRATE));
                    product.setCaloriesPer100gr(rs.getDouble(CALORIES_PER_100_GR));
                    products.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return products;
        };
        return super.findAll("SELECT * FROM products", productMapper);

    }
}
