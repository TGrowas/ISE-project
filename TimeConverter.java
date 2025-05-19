

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TimeConverter {
    private static final Map<String, String> COUNTRY_TIMEZONES = new HashMap<>();

    static {
        COUNTRY_TIMEZONES.put("USA", "America/New_York");
        COUNTRY_TIMEZONES.put("Japan", "Asia/Tokyo");
        COUNTRY_TIMEZONES.put("Australia", "Australia/Sydney");
        COUNTRY_TIMEZONES.put("UK", "British/London");
        COUNTRY_TIMEZONES.put("India", "Asia/Kolkata");
        COUNTRY_TIMEZONES.put("Singapore", "Asia/Singapore City");
        COUNTRY_TIMEZONES.put("German", "Berlin");
        COUNTRY_TIMEZONES.put("China", "Chinese/Beijing");
        COUNTRY_TIMEZONES.put("Spain", "Madrid");
        COUNTRY_TIMEZONES.put("Argentina", "Buenos Aires");
        COUNTRY_TIMEZONES.put("Brazil", "Brasilia");
        COUNTRY_TIMEZONES.put("Malaysia", "Malaysian/");
        COUNTRY_TIMEZONES.put("Bulgaria", "Bulgarian/Sofia");
        COUNTRY_TIMEZONES.put("Eypt", "Eyptian/Cairo");
        COUNTRY_TIMEZONES.put("Mexico", "Mexican/Mexico City");
        COUNTRY_TIMEZONES.put("Finland", "Finnish/Helsiki");
        COUNTRY_TIMEZONES.put("United States", "Washington, D.C.");
        COUNTRY_TIMEZONES.put("Canada", "Canadian/Ottawa");
        COUNTRY_TIMEZONES.put("Guatemala", "Guatemala City");
        COUNTRY_TIMEZONES.put("Belize", "Belmopan");
        COUNTRY_TIMEZONES.put("South korean", "Seoul");
        COUNTRY_TIMEZONES.put("New Zealand", "Wellington");
        COUNTRY_TIMEZONES.put("Chile", "Santiago");
        COUNTRY_TIMEZONES.put("South Africa", "Cape Town");
        
        

        // Add more countries as needed
    }

    public static boolean isValid24HourFormat(String time) {
        // Matches HH:mm format, 00:00 to 23:59
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }
    
    public static String convertTime(String sourceCountry, String targetCountry, String localTime) {
        try {
            String sourceZone = COUNTRY_TIMEZONES.get(sourceCountry);
            String targetZone = COUNTRY_TIMEZONES.get(targetCountry);

            if (sourceZone == null || targetZone == null) {
                return "Invalid country name.";
            }

            LocalTime time = LocalTime.parse(localTime); // e.g. 15:45
            LocalDate today = LocalDate.now();
            ZonedDateTime sourceZoned = ZonedDateTime.of(today, time, ZoneId.of(sourceZone));
            ZonedDateTime targetZoned = sourceZoned.withZoneSameInstant(ZoneId.of(targetZone));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return "Converted time in " + targetCountry + ": " + formatter.format(targetZoned.toLocalTime());
        } catch (Exception e) {
            return "Error: Invalid time format. Use HH:mm (e.g., 15:30)";
        }
    }
}
