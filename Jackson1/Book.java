import java.io.*;

public class Book implements Serializable{
  private String bname;
  private String author;
  private String isbn;
  
public Book(String bname, String author, String isbn) {
	super();
	this.bname = bname;
	this.author = author;
	this.isbn = isbn;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
  
  
}
