package com.company;
import Lab2.impl.*;

public class ValidationHandler {
    static EmailValidator emailVal = new EmailValidator();
    static PasswordChecker passVal = new PasswordChecker();
    static PhoneValidator numVal = new PhoneValidator();

    static Boolean isUserInfoValid(User user) {
        if (passVal.isValid(user.password)==false) {
            System.out.println();
            System.out.println("Ivestas slaptazodis nera validus");
            return false;
        }
        if (emailVal.isValid(user.email)==false) {
            System.out.println();
            System.out.println("Ivestas el. pastas nera validus");
            return false;
        }
        if (numVal.isValid(user.number)==false) {
            System.out.println();
            System.out.println("Ivestas telefono numeris nera validus");
            return false;
        }
        return true;
    }

    static Boolean isEmailValid(String email) {
        if (emailVal.isValid(email)==false) {
            System.out.println();
            System.out.println("Ivestas el. pastas nera validus");
            return false;
        }
        return true;
    }
}
