package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser("Alex", "Alexov", (byte) 5);
        userService.saveUser("Tim", "Timov", (byte) 64);
        userService.saveUser("Max", "Maxov", (byte) 13);
        userService.saveUser("Agata", "Agatov", (byte) 28);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

