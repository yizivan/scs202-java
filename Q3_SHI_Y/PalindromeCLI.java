package Q3_SHI_Y;
import java.util.Scanner;

public class PalindromeCLI
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String candidate = null; 
        final String STOP = "X"; 

        while (!STOP.equals(candidate))
        {
            System.out.print("String (" + STOP + " to stop): ");
            candidate = scan.nextLine();
            if (!STOP.equals(candidate))
            {
                if (Palindrome.test(candidate))
                    System.out.println("is a palindrome.\n");
                else
                    System.out.println("is NOT a palindrome.\n");
            }
        }
        scan.close();
    }
}