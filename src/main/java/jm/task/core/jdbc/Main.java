package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userDaoHibernate = new UserServiceImpl();
        userDaoHibernate.createUsersTable();
        try {
            addUser(userDaoHibernate, "Bruce", "Wayne", (byte) 40);
            addUser(userDaoHibernate, "Toni", "Stark", (byte) 45);
            addUser(userDaoHibernate, "Dean", "Winchester", (byte) 30);
            addUser(userDaoHibernate, "Sam", "Winchester", (byte) 25);

            List<User> users = userDaoHibernate.getAllUsers();
            for (User user : users) {
                System.out.println(user);
            }

            userDaoHibernate.cleanUsersTable();
            userDaoHibernate.dropUsersTable();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeSessionFactory();
        }
    }

    private static void addUser(UserService userDaoHibernate, String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }
}
