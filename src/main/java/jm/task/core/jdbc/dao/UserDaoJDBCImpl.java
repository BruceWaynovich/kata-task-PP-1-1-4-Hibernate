//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    private final Connection connection;
//
//    public UserDaoJDBCImpl() {
//        try {
//            this.connection = Util.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS users (" +
//                "id INT AUTO_INCREMENT PRIMARY KEY, " +
//                "name VARCHAR(100) NOT NULL, " +
//                "lastName VARCHAR(100) NOT NULL, " +
//                "age TINYINT NOT NULL)";
//
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users";
//
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO USERS (name, lastName, age) VALUES (?,?,?)";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, name);
//            statement.setString(2, lastName);
//            statement.setByte(3, age);
//            statement.executeUpdate();
//            System.out.println("User с именем " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> usersList = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(sql)) {
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//
//                usersList.add(user);            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return usersList;
//    }
//
//    public void cleanUsersTable() {
//        String sql = "DELETE FROM users";
//
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
