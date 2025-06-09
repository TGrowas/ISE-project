import java.beans.Transient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


public class MenuTest_Junit {

    @Test
    public void testInvalidMenuChoice() {
        String input = "5\n3\n";
        String expectedOutput = "Invalid choice! Please try again.";

        String output = runMenuWtihInput(input);
        assertTrue(output.contains(expectedOutput));
    }

    @Test
    public void testValidTimeConversion(){
        String input = "1\nUSA\nJapan\n13:00\n3\n";
        String output = runMenuWithInput(input);
        assertTrue(output.contains("Converted time in Japan"));
    }

    @Test


}
