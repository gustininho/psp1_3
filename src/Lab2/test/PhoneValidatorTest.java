package Lab2.test;

import Lab2.impl.PhoneValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorTest {

    private final String TESTCASE_WITHLETTERS = "1234abcd";

    private final String TESTCASE_BAD1 = "+3706+53167346";
    private final String TESTCASE_BAD2 = "#370653167346";
    
    private final String TESTCASE_VALID_LT = "853167346";
    private final String TESTCASE_VALID_LT_EXPECTED = "+37053167346";
    private final String TESTCASE_NOTVALID_LT = "053167346";
    
    private final String TESTCASE_VALID_CUSTOM = "+444555666";
    private final String TESTCASE_NOTVALID_CUSTOM = "+4445556667";

    PhoneValidator phoneValidator;

    @BeforeEach
    public void init() {
        phoneValidator = new PhoneValidator();
    }

    //Phone can contain digit or symbol '+'
    @Test
    public void testShouldOnlyConsistOfDigits() {
        boolean result1 = phoneValidator.isValid(TESTCASE_WITHLETTERS);
        boolean result2 = phoneValidator.isValid(TESTCASE_VALID_LT);
        boolean result3 = phoneValidator.isValid(TESTCASE_NOTVALID_LT);
        boolean result4 = phoneValidator.isValid(TESTCASE_VALID_CUSTOM);
        boolean result5 = phoneValidator.isValid(TESTCASE_NOTVALID_CUSTOM);
        boolean result6 = phoneValidator.isValid(TESTCASE_BAD1);
        boolean result7 = phoneValidator.isValid(TESTCASE_BAD2);

        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertTrue(result5);
        assertFalse(result6);
        assertFalse(result7);
    }

    //Only if number starts with '8' (not any other digit or '+') can be converted
    @Test
    public void testShouldConvertLTToCountryCode() {
        boolean result1 = phoneValidator.isValid(TESTCASE_VALID_LT);
        boolean result2 = phoneValidator.isValid(TESTCASE_NOTVALID_LT);

        assertTrue(result1);
        assertFalse(result2);
        assertEquals(TESTCASE_VALID_LT_EXPECTED, phoneValidator.convertFromLT(TESTCASE_VALID_LT));
    }

    @Test
    public void testShouldUseCustomPrefixAndLength() {
        boolean result4 = phoneValidator.isValid(TESTCASE_VALID_CUSTOM, "+444", 10);
        boolean result5 = phoneValidator.isValid(TESTCASE_NOTVALID_CUSTOM, "+444", 10);

        assertTrue(result4);
        assertFalse(result5);
    }
}
