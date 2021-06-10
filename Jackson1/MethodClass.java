import java.util.Scanner;
public class MethodClass
{
    private Scanner keyboard = new Scanner(System.in);
    private String sentense;
    public MethodClass()
    {
        sentense = null;
    }
    public void MethodDo()
    {
        System.out.println("Please write something");
        sentense = keyboard.nextLine();
    }
    public String toString()
    {
        return ("You have just entered: " + sentense);
    }
}