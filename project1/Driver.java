import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
public class Driver
{
    private static P1_List myLP1_List = new P1_List();
    private static Scanner keyboard = new Scanner(System.in);
    public static int ReturnInt()
    {
        String str;
        Boolean bo;
        int enterint = 0;
        bo = false;
        do
        {
            try
            {
                str = keyboard.nextLine();
                enterint = Integer.valueOf(str);
                if (enterint != 1 && enterint != 2 && enterint != 3 && enterint != 4)
                    enterint = Integer.valueOf("asd");
                bo = true;
            }
            catch(Throwable e)
            {
                System.out.println("wrong enter type, please enter 1,2 or 3.");
                bo = false;
            }
        }
        while (!bo);
        return (enterint);
    }
    public static int ReadingChoice()
    {
        System.out.println("Enter 1 if you want to see the linklist.");
        System.out.println("Enter 2 if you want to see the string representation.");
        System.out.println("Enter 3 if you want to change class position.");
        System.out.println("Enter 4 if you want to quit.");
        return ReturnInt();
    }
    public static void PrintList()
    {
        myLP1_List.printList();
    }
    public static void ShowPresentation()
    {
        System.out.println("There are the all String in the list:");
        PrintList();
        System.out.println("Which String's presentation you want to check?");
        String enterString = keyboard.nextLine();
        if ( myLP1_List.checkList(enterString) == null)
        {
            System.out.println("There is no any String as you enter in the list.");
        }
        else
        {
            System.out.println("The string representation of " + enterString + " is:");
            System.out.println(myLP1_List.checkList(enterString).data);
        }
    }
    public static void MovingElement()
    {
        System.out.println("There are the all String in the list:");
        PrintList();
        System.out.println("Which class you want to change the position? Please enter the classCode.");
        String enterString = keyboard.nextLine();
        if (myLP1_List.checkList(enterString) == null)
        {
            System.out.println("There is no any String as you enter in the list.");
        }
        else
        {
            System.out.println("Where you want to move " + enterString + " to?");
            String movingAction = keyboard.nextLine();
            String[] tmdStrings = new String[2];
            try
            {
                tmdStrings = movingAction.split(" ");
                myLP1_List.checkList(tmdStrings[1]);
            }
            catch (Exception e)
            {
                System.out.println("wrong enter.");
                return;
            }
            
            if (myLP1_List.checkList(tmdStrings[1]) == null)
            {
                System.out.println("There is no any String as you enter in the list.");
            }
            else
            {
                myLP1_List.insertLLNode(myLP1_List.checkList(enterString), myLP1_List.checkList(tmdStrings[1]), tmdStrings[0]);
                PrintList();
            }
        }
    }
    public static void main(String[] args)
    {
        File inFile = new File("p1.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            String nextLine = inBufReader.readLine();
            while (nextLine != null)
            {
                myLP1_List.add(nextLine);
                nextLine = inBufReader.readLine();
            }
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        while (true)
        {
            int choice = ReadingChoice();
            if (choice == 1)
            {
                System.out.println("A linked list has been built:");
                PrintList();
            }
            if (choice == 2)
            {
                ShowPresentation();
            }
            if (choice == 3)
            {
                MovingElement();
            }
            if (choice == 4)
            {
                break;
            }
            System.out.println("continue? (please enter yes or no)");
            if(keyboard.nextLine().toUpperCase().equals("NO"))
            {
                break;
            }
        }
    }
}