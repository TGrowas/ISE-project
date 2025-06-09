import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TimeConverter_Junit {

    // Test 1: Valid conversion
    @Test
    public void testValidConversion() {
        String result = TimeConverter.convertTime("USA", "Japan", "21:30");
        assertNotNull("Should return a time string", result);
        assertTrue("Should start with converted message", result.startsWith("Converted time in Japan:"));
    }

    // Test 2: Invalid source country
    @Test
    public void testInvalidSourceCountry() {
        String result = TimeConverter.convertTime("Unknown", "Japan", "14:49");
        assertEquals("Invalid country name.", result);
    }

    // Test 3: Invalid target country
    @Test
    public void testInvalidTargetCountry() {
        String result = TimeConverter.convertTime("USA", "Mars", "07:34");
        assertEquals("Invalid country name.", result);
    }

    // Test 4: Invalid time format
    @Test
    public void testInvalidTimeFormat() {
        String result = TimeConverter.convertTime("USA", "Japan", "25:00");
        assertTrue("Should return time format error", result.contains("Invalid time format"));
    }

    // Test 5: Black-box - valid countries
    @Test
    public void testBlackBoxValidInput() {
        String result = TimeConverter.convertTime("China", "Malaysia", "02:14");
        assertTrue("Should convert time to Malaysia", result.startsWith("Converted time in Malaysia:"));
    }

    // Test 6: Black-box - invalid source
    @Test
    public void testBlackBoxInvalidSource() {
        String result = TimeConverter.convertTime("Moon", "Malaysia", "02:14");
        assertEquals("Invalid country name.", result);
    }
}
