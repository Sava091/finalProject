package com.vitaliy.training.finalProject.dao;

import com.vitaliy.training.finalProject.model.Coefficient;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class СoefficientDaoImpl extends AbstractDao<Coefficient> implements CoefficientDao {

    private static Logger logger = Logger.getLogger(СoefficientDaoImpl.class);
    public static final String IDCOEFFICIENTS = "idCoefficients";
    public static final String COEF0 = "coef0";
    public static final String COEF1 = "coef1";
    public static final String COEF2 = "coef2";
    public static final String COEF3 = "coef3";
    public static final String SEX = "sex";
    private static final CoefficientDao instance = new СoefficientDaoImpl("jdbc:mysql://localhost:3306/fitnesstracking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            "root", "root");

    public static CoefficientDao getInstance() {
        return instance;
    }

    public СoefficientDaoImpl(String uri, String userName, String password) {
        super(uri, userName, password);
    }

    @Override
    public boolean create(Coefficient сoefficient) {
        logger.info("Coefficient create");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql1 = "INSERT INTO coefficients (idCoefficients, coef0, coef1, coef2, coef3, sex) " +
                    "VALUES(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql1);
            statement.setLong(1, сoefficient.getIdСoefficient());
            statement.setDouble(2, сoefficient.getCoef0());
            statement.setDouble(3, сoefficient.getCoef1());
            statement.setDouble(4, сoefficient.getCoef2());
            statement.setDouble(5, сoefficient.getCoef3());
            statement.setString(6, сoefficient.getSex());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public Coefficient read(Long id) {
        logger.info("Coefficient read");
        Mapper<Coefficient> coefficientMapper = rs -> {
            try {
                if (rs.next()) {
                    final Coefficient сoefficient = new Coefficient();
                    сoefficient.setIdСoefficient(rs.getLong(IDCOEFFICIENTS));
                    сoefficient.setCoef0(rs.getDouble(COEF0));
                    сoefficient.setCoef1(rs.getDouble(COEF1));
                    сoefficient.setCoef2(rs.getDouble(COEF2));
                    сoefficient.setCoef3(rs.getDouble(COEF3));
                    сoefficient.setSex(rs.getString(SEX));
                    return сoefficient;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new Coefficient();
        };
        return super.read("SELECT * FROM coefficients where id = " + id, coefficientMapper);
    }

    @Override
    public boolean update(Coefficient сoefficient) {
        logger.info("Coefficient update");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql2 = "UPDATE coefficients SET coef0=?, coef1=?, coef2=?, coef3=?, sex=?" +
                    "WHERE idCoefitients =?";
            statement = connection.prepareStatement(sql2);
            statement.setDouble(1, сoefficient.getCoef0());
            statement.setDouble(2, сoefficient.getCoef1());
            statement.setDouble(3, сoefficient.getCoef2());
            statement.setDouble(4, сoefficient.getCoef3());
            statement.setString(5, сoefficient.getSex());
            statement.setLong(6, сoefficient.getIdСoefficient());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public boolean delete(Coefficient сoefficient) {
        logger.info("Coefficient delete");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            final String sql3 = "DELETE FROM coefficients WHERE id=?";
            statement = connection.prepareStatement(sql3);
            statement.setLong(1, сoefficient.getIdСoefficient());
            return statement.executeUpdate() >= 1;

        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(connection, statement, resultSet);
        }
        return false;
    }

    @Override
    public Coefficient readBySex(String sex) {
        logger.info("Coefficient readBySex");
        Mapper<Coefficient> coefficientMapper = rs -> {
            try {
                if (rs.next()) {
                    final Coefficient сoefficient = new Coefficient();
                    сoefficient.setIdСoefficient(rs.getLong(IDCOEFFICIENTS));
                    сoefficient.setCoef0(rs.getDouble(COEF0));
                    сoefficient.setCoef1(rs.getDouble(COEF1));
                    сoefficient.setCoef2(rs.getDouble(COEF2));
                    сoefficient.setCoef3(rs.getDouble(COEF3));
                    сoefficient.setSex(rs.getString(SEX));
                    return сoefficient;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return new Coefficient();
        };
        return super.read("SELECT * FROM coefficients where sex = " + sex, coefficientMapper);
    }

    @Override
    public List<Coefficient> findAll() {
        logger.info("Coefficient findAll");
        Mapper<List<Coefficient>> coefficientMapper = rs -> {
            List<Coefficient> сoefficients = new ArrayList<>();
            try {
                while (rs.next()) {
                    final Coefficient сoefficient = new Coefficient();
                    сoefficient.setIdСoefficient(rs.getLong(IDCOEFFICIENTS));
                    сoefficient.setCoef0(rs.getDouble(COEF0));
                    сoefficient.setCoef1(rs.getDouble(COEF1));
                    сoefficient.setCoef2(rs.getDouble(COEF2));
                    сoefficient.setCoef3(rs.getDouble(COEF3));
                    сoefficient.setSex(rs.getString(SEX));
                    сoefficients.add(сoefficient);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return сoefficients;
        };
        return super.findAll("SELECT * FROM coefficients", coefficientMapper);
    }
}
