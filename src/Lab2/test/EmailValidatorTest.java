package Lab2.test;

import Lab2.impl.EmailValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {

    private final String TESTCASE_NOAT = "myemail.gmail.com";

    private final String TESTCASE_ILLEGALCHARS = "$$email??@gmail.com";

    private final String TESTCASE_BADDOMAIN1 = "myemail@non.existing.domain.";
    private final String TESTCASE_BADDOMAIN2 = "myemail@bad@domain.com";
    private final String TESTCASE_BADDOMAIN3 = "myemail@very.bad$domain.com";
    private final String TESTCASE_BADDOMAIN4 = "myemail@.com";

    private final String TESTCASE_BADTLD1 = "myemail@gmail.c0m";
    private final String TESTCASE_BADTLD2 = "myemail@gmail.";
    private final String TESTCASE_BADTLD3 = "myemail@gmail";

    private final String TESTCASE_OK1 = "myemail@gmail.com";
    private final String TESTCASE_OK2 = "myemail@mail.gov.uk";

    EmailValidator emailValidator;

    @BeforeEach
    public void init() {
        emailValidator = new EmailValidator();
    }

    @Test
    public void testShouldContainAtSymbol() {
        boolean result1 = emailValidator.isValid(TESTCASE_NOAT);
        boolean result2 = emailValidator.isValid(TESTCASE_OK1);
        boolean result3 = emailValidator.isValid(TESTCASE_OK2);

        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
    }

    @Test
    public void testShouldNotContainForbiddenSymbols() {
        boolean result1 = emailValidator.isValid(TESTCASE_ILLEGALCHARS);
        boolean result2 = emailValidator.isValid(TESTCASE_OK1);
        boolean result3 = emailValidator.isValid(TESTCASE_OK2);

        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
    }

    @Test
    public void testShouldHaveValidDomain() {
        boolean result1 = emailValidator.isValid(TESTCASE_BADDOMAIN1);
        boolean result2 = emailValidator.isValid(TESTCASE_BADDOMAIN2);
        boolean result3 = emailValidator.isValid(TESTCASE_BADDOMAIN3);
        boolean result4 = emailValidator.isValid(TESTCASE_BADDOMAIN4);
        boolean result5 = emailValidator.isValid(TESTCASE_OK1);
        boolean result6 = emailValidator.isValid(TESTCASE_OK2);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertTrue(result5);
        assertTrue(result6);
    }

    @Test
    public void testShouldHaveValidTLD() {
        boolean result1 = emailValidator.isValid(TESTCASE_BADTLD1);
        boolean result2 = emailValidator.isValid(TESTCASE_BADTLD2);
        boolean result3 = emailValidator.isValid(TESTCASE_BADTLD3);
        boolean result4 = emailValidator.isValid(TESTCASE_OK1);
        boolean result5 = emailValidator.isValid(TESTCASE_OK2);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertTrue(result4);
        assertTrue(result5);
    }
}
