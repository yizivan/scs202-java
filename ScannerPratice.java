import java.util.Scanner;

public class ScannerPratice
{
    private static Scanner keyboard = new Scanner(System.in);
    private static String name;
    private static String color;
    private static String food;
    private static String subject;
    public static void main(String[] args)
    {
        System.out.print("Hello! What is your name? ");
        name = keyboard.nextLine();
        System.out.print("What is your favorite color? ");
        color = keyboard.nextLine();
        System.out.print("What is your favorite food? " );
        food = keyboard.nextLine();
        System.out.print("What is your favorite subject? ");
        subject = keyboard.nextLine();
        System.out.println(name + ":");
        System.out.println("      Color: " + color);
        System.out.println("      Food: " + food);
        System.out.println("      Subject: " + subject);
    }
}