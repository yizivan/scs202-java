import java.io.*;

public class Driver
{
    private static char[] wholeLine;
    private static P2_List myLinkList= new P2_List();
    public static void main(String[] args)
    {
        File inFile = new File("p2.txt");
        try
        {
            FileReader inFileReader = new FileReader(inFile);
            BufferedReader inBufReader = new BufferedReader(inFileReader);
            wholeLine = inBufReader.readLine().toCharArray();
            inBufReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
        String tmdString ="";
        boolean firstOne = true;
        int i = 0;
        while (i < wholeLine.length)
        {
            if ( wholeLine[i] != '(' && wholeLine[i] != ')' && wholeLine[i] != ',')
            {
                tmdString = tmdString + String.valueOf(wholeLine[i]);
                i++;
            }
            else if (wholeLine[i] =='(')
            {
                if (firstOne)
                {
                    myLinkList.addNest(tmdString);
                    firstOne = false;
                }
                tmdString = "";
                i++;
                while (wholeLine[i] != '(' && wholeLine[i] != ')' && wholeLine[i] != ',')
                {
                    tmdString = tmdString + String.valueOf(wholeLine[i]);
                    i++;
                }
                myLinkList.addNest(tmdString);
                tmdString = "";
            }
            else if (wholeLine[i] ==')')
            {
                myLinkList.popFromStack();
                tmdString = "";
                i++;
            }
            else if (wholeLine[i] == ',')
            {
                i++;
                while (wholeLine[i] != '(' && wholeLine[i] != ')' && wholeLine[i] != ',')
                {
                    tmdString = tmdString + String.valueOf(wholeLine[i]);
                    i++;
                }
                myLinkList.addNext(tmdString);
                tmdString = "";
            }
            
        }
        System.out.println(myLinkList);
    }

}