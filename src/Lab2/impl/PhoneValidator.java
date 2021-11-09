package Lab2.impl;

public class PhoneValidator {
    public String convertFromLT(String number) {
        if (number.startsWith("8")) {
            number = number.replaceFirst("8", "+370");
        }
        return number;
    }

    public boolean isValid(String number) {
        String numbers = "0123456789";

        //Iteruojama per numerį, ir jei bent simbolis nėra skaičių aibėje, tai numeris turi neskaitinių simbolių
        for (char character : number.toCharArray()) {
            if (!(numbers.indexOf(character) >= 0)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValid(String number, String prefix, int length) {
        if (!isValid(number)) {
            return false;
        }

        return number.startsWith(prefix) && number.length() == length;
    }


}
