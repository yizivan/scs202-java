import java.io.*;

public class Driver
{
    private static String wholeLine;
    private static P3_List myLinkList= new P3_List();
    public static void main(String[] args)
    {
        File inFile = new File("p3.txt");
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
        myLinkList.setLine(wholeLine);
        myLinkList.build(null);
        System.out.println(myLinkList);
    }

}