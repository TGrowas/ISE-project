import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.*;
public class Menu   
{
   public static void main(String[] args)
    {
        TimeConverter t = new TimeConverter();
        SeasonDeterminer s = new SeasonDeterminer();
        //Season ss = new Season();
        Scanner sc = new Scanner(System.in);
        int choice;
        String source_cty,target_cty,time;
        String cty;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
        do 
        {
            System.out.println("\n===World Time & Season App===");
            System.out.println("1. Convert Time");
            System.out.println("2. Determine Current Season");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("\nEnter source country: ");
                    source_cty = sc.next();
                    System.out.print("\nEnter target country: ");
                    target_cty = sc.next();
                    System.out.print("\nEnter local time (HH:mm)): ");
                    time = sc.next();
                    System.out.println(t.convertTime(source_cty,target_cty,time));
                    //do validation
                    break;
                    
               // case 2:
                   //System.out.print("\nEnter country: ");
                   //cty = sc.next();
                   //System.out.print("\nCurrent date(YY/MM/DD): ");
                    //date = LocalDate.parse(input);
                    //s.determineSeason(cty,date);
                  //  String date = sc.nextLine();
                   // s.determineSeason(cty,date);
                   // break;
                case 2:
                    System.out.print("\nEnter country: ");
                    cty = sc.next();
                    System.out.println("Enter current date(YYYY-MM-DD): ");
                    String dateStr = sc.nextLine().trim();
                    try
                    {
                        date = LocalDate.parse(dateStr,formatter);
                        System.out.println(s.determineSeason(cty,date));
                    }catch(DateTimeParseException e)
                    {
                        System.out.println("Invalid date format. Please use YYYY-MM--DD.");
                    }
                    break;
                
                case 3:
                    System.out.println("\nGoodbye!");
                    break;
         
                default:
                    System.out.println("\nInvalid choice! Please try again.");
                    break;
            }
        } while(choice != 3);
        
        sc.close();
    } 
}


