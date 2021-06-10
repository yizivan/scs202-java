import java.io.*;
import java.util.*;

public class Run_Yiyang
{

    private static Scanner keyboard = new Scanner(System.in);
    private static ArrayList<Student_Yiyang> myStudentList = new ArrayList<Student_Yiyang>();
    private static ArrayList<Book_Yiyang> myBookList = new ArrayList<Book_Yiyang>();
    public static void main(String[] args)
    {
        ReadStudent();
        ReadBook();
        // I am going to create a new student and a new book add in the Arraylists.
        System.out.println("Please enter a first name for the first student");
        String temfirstName = keyboard.nextLine();
        System.out.println("Please enter a last name for the first student");
        String temlastName = keyboard.nextLine();
        System.out.println("Please enter a bookname for the first student");
        String tembookName = keyboard.nextLine();
        System.out.println("Please enter a author for the first student");
        String temauthorName = keyboard.nextLine();
        System.out.println("Please enter a isbn for the first student");
        String temisbn = keyboard.nextLine();
        Book_Yiyang temBook = new Book_Yiyang(tembookName, temauthorName, temisbn);
        myBookList.add(temBook);
        Student_Yiyang temStudent = new Student_Yiyang(temfirstName, temlastName);
        temStudent.addBook(temBook);
        myStudentList.add(temStudent);
        for (int i=0; i < myStudentList.size(); i++)
        {
            System.out.println(myStudentList.get(i));
        }
        for (int i=0; i < myBookList.size(); i++)
        {
            System.out.println(myBookList.get(i));
        }
        SaveStudent();
        SaveBook();
    }

    private static void ReadStudent()
    {
        try 
        {
            FileInputStream fi=new FileInputStream("Yiyang_Student.ser");
            ObjectInputStream oi=new ObjectInputStream(fi);
            myStudentList = (ArrayList<Student_Yiyang>) oi.readObject();
            oi.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    private static void ReadBook()
    {
        try 
        {
            FileInputStream fi=new FileInputStream("Yiyang_Book.ser");
            ObjectInputStream oi=new ObjectInputStream(fi);
            myBookList = (ArrayList<Book_Yiyang>) oi.readObject();
            oi.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    private static void SaveBook()
    {
        try 
        {
            FileOutputStream fs=new FileOutputStream("Yiyang_Book.ser");
            ObjectOutputStream os=new ObjectOutputStream(fs);
            os.reset();
            os.writeObject(myBookList);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void SaveStudent()
    {
        try 
        {
            FileOutputStream fs=new FileOutputStream("Yiyang_Student.ser");
            ObjectOutputStream os=new ObjectOutputStream(fs);
            os.reset();
            os.writeObject(myStudentList);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}