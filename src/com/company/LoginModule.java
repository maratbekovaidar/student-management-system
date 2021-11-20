package com.company;

import java.util.Map;
import java.util.Scanner;

class LoginModule {
    Scanner in = new Scanner(System.in);
    static Map<String, String> authData = Reader.readUserFile();

    public static void importData() {
    }

    public String login() {
        String username;
        String password;
        int tryLogin = 3;
        boolean auth = false;

        System.out.println("Welcome to the students management system, please login to your account");
        System.out.println("------------------------------------------------------------------------------------");

        while(tryLogin != 0 && !auth) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("please enter your username:");
            username = in.nextLine();
            System.out.println("please enter your password:");
            password = in.nextLine();

            if (authData.containsKey(username)) {
                if(authData.get(username).equals(password)) {
                    System.out.println("You login success");
                    auth = true;
                    return username;
                } else {
                    tryLogin--;
                    System.out.println("Your entered incorrect password");
                    System.out.println("Your tries have: " + tryLogin);
                }
            } else {
                System.out.println("This account have not in Database");
                tryLogin--;
                System.out.println("Your tries have: " + + tryLogin);
            }
        }
        return null;
    }

}
