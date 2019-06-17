package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Meal;
import com.vitaliy.training.finalProject.model.Product;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealsDaoImpl extends AbstractDao<Meal> implements MealsDao {
    private static final MealsDao instance = new MealsDaoImpl("jdbc:mysql://localhost:3306/fitnesstracking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            "root", "root");
    private static Logger logger = Logger.getLogger(MealsDaoImpl.class);
    public static final String ID = "id";
    public static final String PRODUCT_ID = "productId";
    public static final String MEAL_CLIENT_ID = "meal_client_id";
    public static final String QUANTITY_OF_100GR_PORTIONS = "quantityOf100grPortions";
    public static final String MEAL_DATE = "meal_date";

    private MealsDaoImpl(String uri, String userName, String password) {
        super(uri, userName, password);
    }

    public static MealsDao getInstance() {
        return instance;
    }

    @Override
    public boolean create(Meal meal) {
        logger.info("Meals create");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = new Product();
        try {
            connection = getConnection();

            final String sql = "INSERT INTO meals (meal_client_id, quantityOf100grPortions, meal_date, productId) " +
                    "VALUES(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, meal.getMealClientId());
            statement.setDouble(2, meal.getQuantityOf100grPortions());
            statement.setDate(3, new Date(meal.getDate().getTime()));
            statement.setLong(4, meal.getProduct().getId());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public Meal read(Long id) {
        logger.info("Meals read");
        Mapper<Meal> mealMapper = rs -> {
            try {
                if (rs.next()) {
                    final Meal meal = new Meal();
                    final Product product = new Product();
                    product.setId(rs.getLong(6));
                    product.setName(rs.getString(7));
                    product.setFat(rs.getDouble(8));
                    product.setProtein(rs.getDouble(9));
                    product.setCarbohydrate(rs.getDouble(10));
                    product.setCaloriesPer100gr(rs.getDouble(11));
                    meal.setId(rs.getLong(1));
                    meal.setProduct(product);
                    meal.setMealClientId(rs.getLong(3));
                    meal.setQuantityOf100grPortions(rs.getDouble(4));
                    meal.setDate(rs.getDate(5));
                    return meal;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        };
        return super.read("SELECT m.*, p.* FROM meals m, products p WHERE m.productId = p.id AND m.id = " + id, mealMapper);
    }

    @Override
    public boolean update(Meal meal) {
        logger.info("Meals update");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql = "UPDATE meals SET productId=?, meal_client_id=?, getQuantityOf100grPortions=?, meal_date=?" +
                    " WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, meal.getMealClientId());
            statement.setDouble(2, meal.getQuantityOf100grPortions());
            statement.setDate(3, new Date(meal.getDate().getTime()));
            statement.setLong(4, meal.getId());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public boolean delete(Meal meal) {
        logger.info("Meals delete");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql = "DELETE FROM meals WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, meal.getId());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public List<Meal> findAll(long clientId) {
        return this.findAll(clientId, "");
    }

    private List<Meal> findAll(long clientId, String pagination) {
        logger.info("Meals findAll");
        Mapper<List<Meal>> mealsMapper = rs -> {
            List<Meal> meals = new ArrayList<>();

            try {
                while (rs.next()) {
                    final Meal meal = new Meal();
                    final Product product = new Product();
                    product.setId(rs.getLong(6));
                    product.setName(rs.getString(7));
                    product.setFat(rs.getDouble(8));
                    product.setProtein(rs.getDouble(9));
                    product.setCarbohydrate(rs.getDouble(10));
                    product.setCaloriesPer100gr(rs.getDouble(11));
                    meal.setId(rs.getLong(1));
                    meal.setProduct(product);
                    meal.setMealClientId(rs.getLong(3));
                    meal.setQuantityOf100grPortions(rs.getDouble(4));
                    meal.setDate(rs.getDate(5));
                    meals.add(meal);
                }
            } catch (final SQLException e) {
                e.printStackTrace();
            }
            return meals;
        };

        return super.findAll("SELECT m.*, p.* FROM meals m, products p WHERE m.productId = p.id  AND meal_client_id = " + clientId + " " + pagination, mealsMapper);

    }

    @Override
    public List<Meal> findAll(long clientId, int page, int pageSize) {
        String pagination = "LIMIT " + pageSize + " OFFSET " + page * pageSize;
        return this.findAll(clientId, pagination);
   }
}
