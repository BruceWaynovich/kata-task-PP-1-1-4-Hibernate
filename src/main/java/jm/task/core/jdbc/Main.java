package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Bruce", "Wayne", (byte) 40);
        userDao.saveUser("Toni", "Stark", (byte) 45);
        userDao.saveUser("Dean", "Winchester", (byte) 30);
        userDao.saveUser("Sam", "Winchester", (byte) 25);

        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
