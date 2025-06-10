import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

@RunWith(JUnit4.class)
public class MenuTest_Junit {

     @Test
    public void testInvalidDoubleMenuChoice() {
        
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("0.1\n3".getBytes()));
        Menu.main(new String[]{});

        String output = capOut.toString();
        assertTrue("Test for input is Double data type ",output.contains("Invalid choice! Please try again."));
    }

     @Test
    public void testInvalidNegativeMenuChoice() {
        
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("-1\n3".getBytes()));
        Menu.main(new String[]{});

        String output = capOut.toString();
        assertTrue("Test for input is Negative number ",output.contains("Invalid choice! Please try again."));
    }
     @Test
    public void testValidTimeConverter() {
        
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("1\nUSA\nJapan\n13:00\n3".getBytes()));
        Menu.main(new String[]{});

        String output = capOut.toString();
        assertTrue("Test for Time Converter is work ",output.contains("Converted time in Japan: 02:00"));
    }

     @Test
    public void testInValidTimeTimeConverter() {
        
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("1\nUSA\nJapan\n25:00\n3".getBytes()));
        Menu.main(new String[]{});

        String output = capOut.toString();
        assertTrue("Test for Invalid Time",output.contains("Text '25:00' could not be parsed: Invalid value for HourOfDay (valid values 0 - 23): 25"));
    }

    @Test
    public void testInValidCountryTimeConverter() {
        
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("1\nusa\nJapan\n25:00\n3".getBytes()));
        Menu.main(new String[]{});

        String output = capOut.toString();
        assertTrue("Test for Invalid Country Name",output.contains("Invalid country name."));
    }

    @Test
    public void testSeasonDeterminer() {
        
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("2\nAustralia\n2025-01-15\n3".getBytes()));
        Menu.main(new String[]{});

        String output = capOut.toString();
        assertTrue("Test for Season Determiner",output.contains("Current season in Australia: Summer"));
    }

    @Test
    public void testInvalidDateSeasonDeterminer() {
        
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("2\nAustralia\n2025-13-01\n3".getBytes()));
        Menu.main(new String[]{});

        String output = capOut.toString();
        assertTrue("Test for Invalid Date in Season Determiner",output.contains("Invalid date format. Please use YYYY-MM-DD."));
    }



    


}
