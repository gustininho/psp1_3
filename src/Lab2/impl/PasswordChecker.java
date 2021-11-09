package Lab2.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordChecker {
    private final int length;
    private final List<String> specialSymbols;

    public PasswordChecker() {
        this.length = 8;
        this.specialSymbols = Arrays.stream("!@#$%^&*()-=+".split("")).collect(Collectors.toList());
    }

    public PasswordChecker(int length, String chars) {
        this.length = length;
        this.specialSymbols = Arrays.stream(chars.split("")).collect(Collectors.toList());
    }

    //Sujungiami trijų taisyklių teisingumai
    public boolean isValid(String password){
        return passwordLongEnough(password, this.length)
                && containsUppercase(password)
                && containsSpecialSymbol(password, this.specialSymbols);
    }

    private boolean passwordLongEnough(String password, int length) {
        return password.length() >= length;
    }

    private boolean containsUppercase(String password) {
        return !password.toLowerCase().equals(password);
    }

    //Iteruojama per specialius simbolius ir žiūrima ar yra bent vienas iš jų.
    private boolean containsSpecialSymbol(String s, List<String> symbols) {
        boolean doesContain = false;
        for (String symbol: symbols) {
            doesContain = doesContain || s.contains(symbol);
        }
        return doesContain;
    }
}
