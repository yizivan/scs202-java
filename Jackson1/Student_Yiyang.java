import java.util.*;

public class Student_Yiyang implements java.io.Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private ArrayList<Book_Yiyang> myBooks;
    public Student_Yiyang()
    {
        myBooks = new ArrayList<Book_Yiyang>();
    }
    public Student_Yiyang(String firstname, String lastname)
    {
        firstName = firstname;
        lastName = lastname;
        myBooks = new ArrayList<Book_Yiyang>();
    }
    public Student_Yiyang(String firstname, String lastname, ArrayList<Book_Yiyang> books)
    {
        firstName = firstname;
        lastName = lastname;
        myBooks = books;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public ArrayList<Book_Yiyang> getBooks()
    {
        return myBooks;
    }
    public void addBook(Book_Yiyang newbook)
    {
        myBooks.add(newbook);
    }
    public String toString()
    {
        return (firstName + " " + lastName + " ");
    }
}