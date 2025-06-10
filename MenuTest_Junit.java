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
        asserTrue("Test for input is Double data type ",output.contains("Invalid choice! Please try again."));
    }
     @Test
    public void testValidTimeConverter() {
        
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("1\nUSA\nJapan\n13:00\n3".getBytes()));
        Menu.main(new String[]{});

        String output = capOut.toString();
        asserTrue("Test for Time Converter is work ",output.contains("Invalid choice! Please try again."));
    }

    @Test
    public void testValidTimeConversion(){
        String input = "1\nUSA\nJapan\n13:00\n3\n";
        String output = runMenuWithInput(input);
        assertTrue(output.contains("Converted time in Japan"));
    }

    


}
