package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
//        Util.getConnection();
//        UserDao userDao = new UserDaoJDBCImpl();
        UserDao userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

        userDaoHibernate.saveUser("Bruce", "Wayne", (byte) 40);
        userDaoHibernate.saveUser("Toni", "Stark", (byte) 45);
        userDaoHibernate.saveUser("Dean", "Winchester", (byte) 30);
        userDaoHibernate.saveUser("Sam", "Winchester", (byte) 25);

        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
    }
}
