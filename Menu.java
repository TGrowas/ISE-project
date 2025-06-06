import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.*;
public class MENU   
{
   public static void main(String[] args)
    {
        TimeConverter t = new TimeConverter();
        SeasonDeterminer s = new SeasonDeterminer();
        Scanner sc = new Scanner(System.in);
        String choice;
        String source_cty,target_cty,time,resultTime;
        String cty,input,resultSeason;
        DateTimeFormatter seasonFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
        do 
        {
            System.out.println("\n===World Time & Season App===");
            System.out.println("1. Convert Time");
            System.out.println("2. Determine Current Season");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.next();

            switch (choice) 
            {
                case "1":
                    System.out.print("\nEnter source country: ");
                    source_cty = sc.next();
                    System.out.print("\nEnter target country: ");
                    target_cty = sc.next();
                    System.out.print("\nEnter local time (HH:mm): ");
                    time = sc.next();
                    resultTime = t.convertTime(source_cty,target_cty,time);
                    System.out.println("\n" + resultTime);
                    break;
                    
               
                case "2":
                    System.out.print("\nEnter country: ");
                    cty = sc.next();
                    System.out.print("Enter current date(YYYY-MM-DD): ");
                    input = sc.next();
                    try
                    {
                        date = LocalDate.parse(input, seasonFormatter);
                        resultSeason = s.determineSeason(cty,date);
                        System.out.println("\n" + resultSeason);
                        
                    }catch(DateTimeParseException e)
                    {
                        System.out.println("Invalid date format. Please use YYYY-MM--DD.");
                    }
                    break;
                
                case "3":
                    System.out.println("\nGoodbye!");
                    break;
         
                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;
            }
        } while(choice != "3" );
        
        sc.close();
    } 
}


