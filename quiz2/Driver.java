import java.io.*;
import java.util.Scanner;
public class Driver
{
    private static String wholeLine;
    private static Q2_List myLinkList= new Q2_List();
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        File inFile = new File("q2.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            wholeLine = inBufReader.readLine();
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        String[] myString = wholeLine.split(" ");
        int i = 0;
        while (i < myString.length)
        {
            if(!myString[i].equals("(") && !myString[i].equals(")"))
            {
                myLinkList.addNext(myString[i]);
                i++;
            }
            else if (myString[i].equals("("))
            {
                i++;
                myLinkList.addNest(myString[i]);
                i++;
            }
            else if (myString[i].equals(")"))
            {
                myLinkList.popFromStack();
                i++;
            }
        }
        System.out.println("The file has been read.");
        while (true)
        {
            System.out.println("What level do you want to merge?");
            String[] readInt = keyboard.nextLine().split(" ");
            int level1 = Integer.valueOf(readInt[0]);
            int level2 = Integer.valueOf(readInt[1]);
            myLinkList.printLevel(level1);
            myLinkList.printLevel(level2);
            System.out.println("If you want to try again please enter yes, otherwise enter anything else.");
            if (!keyboard.nextLine().toUpperCase().equals("YES"))
                break;
            
        }
        System.out.println(myLinkList);
    }

}