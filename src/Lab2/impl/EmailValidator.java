package Lab2.impl;

import Lab2.impl.helpers.TldData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmailValidator {
    private final static String VALID_SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWYZabcdefghijklmnopqrstuvwxyz-";

    public boolean isValid(String address) {
        //Jei nėra @ arba jei yra daugiau nei vienas, tai adresas nevalidus
        if (!address.contains("@") || address.replaceFirst("@", "").contains("@")) {
            return false;
        }

        String domain = address.substring(address.indexOf('@')+1);
        String[] subDomains = domain.split("\\.");

        boolean domainValidity = true;

        //Jei aibė mažesnė nei 2, tai reiškia, kad nebus tld arba domeno.
        if (subDomains.length < 2) {
            return false;
        }

        //Tikriname ar visi domenai (subdomenai) ir TLd yra validūs
        for (int i = 0; i < subDomains.length; i++) {
            if (i == subDomains.length - 1) {
                domainValidity = domainValidity && isTldValid("." + subDomains[i]);
            } else {
                domainValidity = domainValidity && isDomainValid(subDomains[i]);
            }
        }

        if (!domainValidity) {
            return false;
        }

        address = address.replace("@", "");
        address = address.replace(".", "");

        //Tikriname ar nėra neleidžiamų simbolių
        for (char character : VALID_SYMBOLS.toCharArray()) {
            address = address.replace(character + "", "");
        }

        if (address.length() > 0) {
            return false;
        }

        return true;
    }

    //Atsidarome pilną TLD sąrašą ir tikriname ar esamas TLD egzistuoja oficialiame sąraše.
    private boolean isTldValid(String tld) {
        List<TldData> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Lab2/resources/validTldList.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(tld)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }


    /*
    The valid domain name must satisfy the following conditions:

        The domain name should be a-z or A-Z or 0-9 and hyphen (-).
        The domain name should be between 1 and 63 characters long.
        The domain name should not start or end with a hyphen(-) (e.g. -geeksforgeeks.org or geeksforgeeks.org-).
        The last TLD (Top level domain) must be at least two characters and a maximum of 6 characters.
        The domain name can be a subdomain (e.g. contribute.geeksforgeeks.org).
     */
    private boolean isDomainValid(String domain) {

        for (char character : domain.toCharArray()) {
            if (!(VALID_SYMBOLS.indexOf(character) >= 0)) {
                return false;
            }
        }

        if (1 > domain.length() || domain.length() > 63) {
            return false;
        }

        if (domain.startsWith("-") || domain.endsWith("-")) {
            return false;
        }

        return true;
    }

}
