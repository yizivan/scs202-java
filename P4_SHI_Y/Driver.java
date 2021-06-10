package P4_SHI_Y;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
public class Driver
{
    private static String wholeLine;
    private static P4Tree myTree = new P4Tree();
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        File inFile = new File(".\\src\\P4_SHI_Y\\p4.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            while ((wholeLine = inBufReader.readLine()) != null)
            {
                myTree.addNode(wholeLine);
            }
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        System.out.println(myTree);
        while (true)
        {
            System.out.println("Node to be removed?");
            String enter = keyboard.nextLine();
            myTree.remove(enter);
            System.out.println(myTree);
            System.out.println("If you want to remove again, enter yes, otherwise enter anything else.");
            if (!keyboard.nextLine().toUpperCase().equals("YES"))
                break;
        }
        
    }
}