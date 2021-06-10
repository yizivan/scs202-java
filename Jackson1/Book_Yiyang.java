public class Book_Yiyang implements java.io.Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String author;
    private String isbn;
    public Book_Yiyang()
    {

    }
    public Book_Yiyang(String name, String author, String isbn)
    {
        this.name = name;
        this.author = author;
        this. isbn = isbn;
    }
    public String getName()
    {
        return name;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public String toString()
    {
        return (name + " " + author + " " + isbn);
    }

}