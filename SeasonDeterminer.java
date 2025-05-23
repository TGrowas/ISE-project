package converter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SeasonDeterminer {
    private static final Set<String> SOUTHERN_HEMISPHERE = new HashSet<>(Arrays.asList(
        "Australia", "New Zealand", "Argentina", "South Africa", "Chile"
    ));

    public static String determineSeason(String country, LocalDate date) {
        boolean isSouthern = SOUTHERN_HEMISPHERE.contains(country);

        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        String season;

        if (isSouthern) {
            if ((month == 12 && day >= 1) || (month <= 2)) {
                season = "Summer ☀️";
            } else if (month >= 3 && month <= 5) {
                season = "Fall 🍂";
            } else if (month >= 6 && month <= 8) {
                season = "Winter ❄️";
            } else {
                season = "Spring 🌸";
            }
        } else {
            if ((month == 12 && day >= 1) || (month <= 2)) {
                season = "Winter ❄️";
            } else if (month >= 3 && month <= 5) {
                season = "Spring 🌸";
            } else if (month >= 6 && month <= 8) {
                season = "Summer ☀️";
            } else {
                season = "Fall 🍂";
            }
        }

        return country + " is in the " + (isSouthern ? "Southern" : "Northern") + " Hemisphere.\n"
             + "Current season in " + country + ": " + season;
    }
}
