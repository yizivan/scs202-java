import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.ArrayList;
public class Driver
{
    private static P6_map myMap = new P6_map();
    private static Scanner keyboard = new Scanner(System.in);
    private static long start, finish, timeElapsed;
    private static String key;
    private static ArrayList<String> sortedWords = new ArrayList<String>();
    private static Sorts mySorts = new Sorts();
    public static void main(String[] args)
    {
        System.out.println("What is the size of each HT?");
        int size = keyboard.nextInt();
        keyboard.nextLine();
        myMap.setUpSize(size);
        String wholeLine;
        start = System.currentTimeMillis();
        File inFile = new File("final_input.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            while ((wholeLine = inBufReader.readLine()) != null)
            {
                if (wholeLine.length() == 0) 
                    break;
                myMap.addLL(wholeLine);
            }
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Chain stats below:");
        System.out.println("time spent on building the HT: " + timeElapsed+" seconds");
        System.out.println("average chain length: " + myMap.getAveChainLengthLL());
        System.out.println("SD: " + myMap.getSDLL());
        start = System.currentTimeMillis();
        inFile = new File("final_search.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            while ((wholeLine = inBufReader.readLine()) != null)
            {
                if (wholeLine.length() == 0) 
                    break;
                myMap.searchLL(wholeLine);
            }
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("# of duplicates: " + myMap.getDupLL());
        System.out.println("time needed to search keys from final_search.txt: " + timeElapsed + " seconds");
        System.out.println("# of entries not found from the search: " + myMap.getNFRLL() + " records");
        start = System.currentTimeMillis();
        inFile = new File("final_input.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            while ((wholeLine = inBufReader.readLine()) != null)
            {
                if (wholeLine.length() == 0) 
                    break;
                myMap.addBST(wholeLine);
            }
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("------------");
        System.out.println("BST stats below:");
        System.out.println("time spent on building the HT: " + timeElapsed+" seconds");
        System.out.println("average chain length: " + myMap.getAveChainLengthBST());
        System.out.println("SD: " + myMap.getSDBST());
        start = System.currentTimeMillis();
        inFile = new File("final_search.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            while ((wholeLine = inBufReader.readLine()) != null)
            {
                if (wholeLine.length() == 0) 
                    break;
                myMap.searchBST(wholeLine);
            }
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("# of duplicates: " + myMap.getDupBST());
        System.out.println("time needed to search keys from final_search.txt: " + timeElapsed + " seconds");
        System.out.println("# of entries not found from the search: " + myMap.getNFRBST() + " records");
        System.out.println("------------");
        System.out.println("Enter a key to remove an entry from the HT-BST:");
        System.out.print(">>");
        
        while (true)
        {
            key = keyboard.nextLine();
            if (myMap.removeBST(key))
            {
                System.out.println("record removed");
                break;
            }
            else
            {
                System.out.println("No record found. Enter a key to remove:");
            }
        }
        inFile = new File("input.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            while ((wholeLine = inBufReader.readLine()) != null)
            {
                if (wholeLine.length() == 0) 
                    break;
                sortedWords.add(wholeLine);
            }
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        String[] input = new String[sortedWords.size()];
        for(int i =0; i < input.length; i++)
        {
            input[i] = sortedWords.get(i);
        }
        
        System.out.println("Selection sort:");
        start = System.currentTimeMillis();
        String[] tmd1 = mySorts.selectedSort(input);
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("1. the time needed " + timeElapsed + " seconds.");
        System.out.println("2. the first word : " + tmd1[0]);
        System.out.println("3. the last word : " + tmd1[tmd1.length-1]);
        System.out.println("==");
        System.out.println("Bubble sort:");
        start = System.currentTimeMillis();
        String[] tmd2 = mySorts.bubbleSort(input);
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("1. the time needed " + timeElapsed + " seconds.");
        System.out.println("2. the first word : " + tmd2[0]);
        System.out.println("3. the last word : " + tmd2[tmd2.length-1]);
        System.out.println("==");
        System.out.println("Shortbubble sort:");
        start = System.currentTimeMillis();
        String[] tmd3 = mySorts.shortBubbleSort(input);
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("1. the time needed " + timeElapsed + " seconds.");
        System.out.println("2. the first word : " + tmd3[0]);
        System.out.println("3. the last word : " + tmd3[tmd3.length-1]);
        System.out.println("==");
        System.out.println("Insertion sort:");
        start = System.currentTimeMillis();
        String[] tmd4 = mySorts.insertionSort(input);
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("1. the time needed " + timeElapsed + " seconds.");
        System.out.println("2. the first word : " + tmd4[0]);
        System.out.println("3. the last word : " + tmd4[tmd4.length-1]);
        System.out.println("==");
        System.out.println("Quick sort:");
        start = System.currentTimeMillis();
        String[] tmd5 = mySorts.quickSort(input);
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("1. the time needed " + timeElapsed + " seconds.");
        System.out.println("2. the first word : " + tmd5[0]);
        System.out.println("3. the last word : " + tmd5[tmd5.length-1]);
        System.out.println("==");
        System.out.println("Merge sort:");
        start = System.currentTimeMillis();
        String[] tmd6 = mySorts.mergeSort(input);
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("1. the time needed " + timeElapsed + " seconds.");
        System.out.println("2. the first word : " + tmd6[0]);
        System.out.println("3. the last word : " + tmd6[tmd6.length-1]);
    }
}