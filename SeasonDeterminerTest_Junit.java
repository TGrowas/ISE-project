import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)

public class SeasonDeterminerTest_Junit {
    SeasonDeterminer s = new SeasonDeterminer();
    @Test
    public void testSouthernHemisphereSummer() {
        LocalDate date = LocalDate.of(2025,1,15);
        assertEquals( "Southern Hemisphere", "Summer", s.determineSeason("Australia", date));
    }

    @Test
    public void testNorthernHemisphereWinter() {
        LocalDate date = LocalDate.of(2025,2,15);
        assertEquals( "Northern Hemisphere", "Winter", s.determineSeason("Japan", date));
    }

    @Test
    public void testSouthernHemisphereFall() {
        LocalDate date = LocalDate.of(2025,4,01);
        assertEquals( "Southern Hemisphere", "Fall", s.determineSeason("Argentina", date));
    }

    @Test
    public void testSouthernHemisphereSpring() {
        LocalDate date = LocalDate.of(2025,2,15);
        assertEquals( "Southern Hemisphere", "Spring", s.determineSeason("New Zealand", date));
    }


}
