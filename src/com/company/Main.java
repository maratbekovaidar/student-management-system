package com.company;

import com.company.service.MenuService;
import com.company.service.StudentsServiceImplementation;

public class Main {
    public static void main(String[] args) {
        String user;
        LoginModule loginModule = new LoginModule();
        user = loginModule.login();
        if (user != null) {
            StudentsServiceImplementation studentsServiceImplementation = new StudentsServiceImplementation();
            MenuService menuService = new MenuService();
        }

    }
}
