import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TimeConverter {
    private static final Map<String, String> COUNTRY_TIMEZONES = new HashMap<>();

    static 
    {
        COUNTRY_TIMEZONES.put("USA", "America/New_York");  
        COUNTRY_TIMEZONES.put("Japan", "Asia/Tokyo");
        COUNTRY_TIMEZONES.put("Australia", "Australia/Sydney");
        COUNTRY_TIMEZONES.put("UK", "Europe/London"); 
        COUNTRY_TIMEZONES.put("India", "Asia/Kolkata");
        COUNTRY_TIMEZONES.put("Singapore", "Asia/Singapore City"); 
        COUNTRY_TIMEZONES.put("Germany", "Europe/Berlin"); 
        COUNTRY_TIMEZONES.put("China", "Asia/Shanghai"); 
        COUNTRY_TIMEZONES.put("Spain", "Madrid");
        COUNTRY_TIMEZONES.put("Argentina", "Buenos Aires");
        COUNTRY_TIMEZONES.put("Brazil", "America/Sao_Paulo"); 
        COUNTRY_TIMEZONES.put("Malaysia", "Asia/Kuala_Lumpur");
        COUNTRY_TIMEZONES.put("Bulgaria", "Bulgarian/Sofia");
        COUNTRY_TIMEZONES.put("Egypt", "Africa/Cairo"); 
        COUNTRY_TIMEZONES.put("Mexico", "Mexican/Mexico City");
        COUNTRY_TIMEZONES.put("Finland", "Finnish/Helsiki");
        COUNTRY_TIMEZONES.put("United States", "Washington, D.C.");
        COUNTRY_TIMEZONES.put("Canada", "America/Toronto"); 
        COUNTRY_TIMEZONES.put("Guatemala", "Guatemala City");
        COUNTRY_TIMEZONES.put("Belize", "Belmopan");
        COUNTRY_TIMEZONES.put("South korean", "Seoul"); 
        COUNTRY_TIMEZONES.put("New Zealand", "Pacific/Auckland"); 
        COUNTRY_TIMEZONES.put("Chile", "Santiago");
        COUNTRY_TIMEZONES.put("South Africa", "Africa/Johannesburg"); 
    }

    public static boolean isValid24HourFormat(String time) {
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }
                                                                                 
    public static String convertTime(String sourceCountry, String targetCountry, String localTime) {
        try 
        {
            String sourceZone = COUNTRY_TIMEZONES.get(sourceCountry);
            String targetZone = COUNTRY_TIMEZONES.get(targetCountry);

            if (sourceZone == null || targetZone == null) {
                return "Invalid country name.";
            }
        
            LocalTime time = LocalTime.parse(localTime); 
            LocalDate today = LocalDate.now();
            
            ZonedDateTime sourceZoned = ZonedDateTime.of(today, time, ZoneId.of(sourceZone));
            ZonedDateTime targetZoned = sourceZoned.withZoneSameInstant(ZoneId.of(targetZone));

            return "Converted time in " + targetCountry + ": " + targetZoned.toLocalTime();
        } catch (ExceptionInInitializerError e) {
            return e.getMessage();
        }
    }
}

