import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
public class Driver
{
    private static String wholeLine;
    private static P5_map myMap = new P5_map();
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        File inFile = new File("P5.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            while ((wholeLine = inBufReader.readLine()) != null)
            {
                if (wholeLine.length() == 0) 
                    break;
                myMap.add(wholeLine);
            }
            while ((wholeLine = inBufReader.readLine()) != null)
            {
                myMap.builBT(wholeLine);
            }
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        System.out.println("Given the input, the BT has been built using a map.");
        System.out.println("Traversal? Enter 1 for preorder, 2 for inorder, or 3 for postorder traversal.");
        System.out.print(">>");
        myMap.printMyBTree(keyboard.nextInt());
        System.out.println();
        System.out.println("Taking the above BT traversal as input, a new BST has been built.");
        System.out.print(">>");
        myMap.printMyBSTree(keyboard.nextInt());
        System.out.println();
        System.out.println("I can predict your semester grade. Answer the following y/n questions.");
        myMap.goThroughBTree();
    }
}