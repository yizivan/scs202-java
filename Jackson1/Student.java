import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	private String fname;
	private String lname;
	private int grade;
	private ArrayList<Book> books;
	public Student(String fname, String lname, int grade, ArrayList<Book> books) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.grade = grade;
		this.books = books;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	

	
}
