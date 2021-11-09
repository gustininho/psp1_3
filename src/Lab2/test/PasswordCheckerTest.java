package Lab2.test;

import Lab2.impl.PasswordChecker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckerTest {

    private final String TESTCASE_SHORT_NOSPECIAL = "shortpw";
    private final String TESTCASE_LONG_NOUPPERCASE = "longpasswordwithoutcapitals";
    private final String TESTCASE_LONG_UPPERCASE = "LoNgPaSsWoRdWiThCaPiTaLlEtTeRs";
    private final String TESTCASE_SHORT_SPECIAL = "p@$$word";
    private final String TESTCASE_OK = "SUp3RDup3RG00DAnDVerYL0nGP@SSW0RD!";

    PasswordChecker passwordChecker;

    @BeforeEach
    public void init() {
        passwordChecker = new PasswordChecker();
    }

    @Test
    public void testPasswordShouldBeLong() {
        boolean result1 = passwordChecker.isValid(TESTCASE_SHORT_NOSPECIAL);
        boolean result2 = passwordChecker.isValid(TESTCASE_LONG_NOUPPERCASE);
        boolean result3 = passwordChecker.isValid(TESTCASE_LONG_UPPERCASE);
        boolean result4 = passwordChecker.isValid(TESTCASE_SHORT_SPECIAL);
        boolean result5 = passwordChecker.isValid(TESTCASE_OK);

        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertTrue(result5);
    }

    @Test
    public void testPasswordShouldHaveUppercaseLetters() {
        boolean result1 = passwordChecker.isValid(TESTCASE_SHORT_NOSPECIAL);
        boolean result2 = passwordChecker.isValid(TESTCASE_LONG_NOUPPERCASE);
        boolean result3 = passwordChecker.isValid(TESTCASE_LONG_UPPERCASE);
        boolean result4 = passwordChecker.isValid(TESTCASE_SHORT_SPECIAL);
        boolean result5 = passwordChecker.isValid(TESTCASE_OK);

        assertFalse(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertTrue(result5);
    }

    @Test
    public void testPasswordShouldHaveSpecialSymbols() {
        boolean result1 = passwordChecker.isValid(TESTCASE_SHORT_NOSPECIAL);
        boolean result2 = passwordChecker.isValid(TESTCASE_LONG_NOUPPERCASE);
        boolean result3 = passwordChecker.isValid(TESTCASE_LONG_UPPERCASE);
        boolean result4 = passwordChecker.isValid(TESTCASE_SHORT_SPECIAL);
        boolean result5 = passwordChecker.isValid(TESTCASE_OK);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertTrue(result4);
        assertTrue(result5);
    }
}
