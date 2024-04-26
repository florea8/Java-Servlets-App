package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.User;


public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Reprezentanta";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Parolasql.";

    private static final String INSERT_USERS_SQL = "INSERT INTO auto" + "  (marca, model, detalii, pret) VALUES " +
        " (?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id, marca, model, detalii, pret from auto where id =?";
    private static final String SELECT_ALL_USERS = "select * from auto";
    private static final String DELETE_USERS_SQL = "delete from auto where id = ?;";
    private static final String UPDATE_USERS_SQL = "update auto set marca=?, model=?, detalii=?, pret=? where id = ?;";

    public UserDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
      
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getMarca());
            preparedStatement.setString(2, user.getModel());
            preparedStatement.setString(3, user.getDetalii());
            preparedStatement.setString(4, user.getPret());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        //  Establishing a Connection
        try (Connection connection = getConnection();
            // Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                String marca = rs.getString("marca");
                String model = rs.getString("model");
                String detalii = rs.getString("detalii");
                String pret = rs.getString("pret");
                user = new User(id, marca, model, detalii, pret);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List < User > selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < User > users = new ArrayList < > ();
        //  Establishing a Connection
        try (Connection connection = getConnection();

            // Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            //  Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //  Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String model = rs.getString("model");
                String detalii = rs.getString("detalii");
                String pret = rs.getString("pret");
                users.add(new User(id, marca, model, detalii, pret));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getMarca());
            statement.setString(2, user.getModel());
            statement.setString(3, user.getDetalii());
            statement.setString(4, user.getPret());
            statement.setInt(5, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}