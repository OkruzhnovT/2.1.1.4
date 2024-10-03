package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    public UserDaoJDBCImpl() {


    }

    public void createUsersTable() throws SQLException {
        Connection connection = getConnection();
        Statement statement = null;
        String create ="CREATE TABLE IF NOT EXISTS `test1` (id INT PRIMARY KEY AUTO_INCREMENT,first_name VARCHAR(100), last_name VARCHAR(100), age INT)";
        try {
        statement = connection.createStatement();
        statement.executeUpdate(create);
        }catch (SQLException e) {
        }finally {
            if (statement != null) {
                statement.close();
            }if (connection != null) {
                connection.close();
            }
        }
    }
    public void dropUsersTable() throws SQLException {
        Connection connection = getConnection();
        Statement statement = null;
        String drop = "DROP TABLE IF EXISTS `test1`";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(drop);
        }catch (SQLException e) {
        }finally {
            if (statement != null) {
                statement.close();
            }if (connection != null) {
                connection.close();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String save = "INSERT INTO `test1` (first_name, last_name, age) VALUES (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(save);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }if (connection != null) {
                connection.close();
            }
        }
    }

    public void removeUserById(long id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String remove = "DELETE FROM `test1` WHERE `id` = ?";
        try {
            preparedStatement = connection.prepareStatement(remove);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }if (connection != null) {
                connection.close();
            }
        }
    }
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String getAll = "SELECT * FROM `test1`";
        Statement statement = null;
        Connection connection = getConnection();
        try {
            statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(getAll);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        }catch (SQLException e) {
        }finally {
            if(statement != null) {
                statement.close();
            }if (connection != null) {
                connection.close();
            }
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        Connection connection = getConnection();
        Statement statement = null;
        String remove = "TRUNCATE TABLE `test1`";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(remove);
        } catch (SQLException e) {
        } finally {
            if (statement != null) {
                statement.close();
            }if (connection != null) {
                connection.close();
            }
        }
    }
}
