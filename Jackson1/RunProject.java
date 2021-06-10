import java.io.*;
import java.util.*;


public class RunProject {
	
		static ArrayList<Book> books = new ArrayList<Book>();
		static ArrayList<Student> students = new ArrayList<Student>();
    
        
		
		static ArrayList<Object> data = new ArrayList<Object>();
		static ArrayList<Object> deserialized = new ArrayList<Object>();
		
		public static void main(String[] args) {
			
			
			Menu();
		}
		public void createData(){
			//inputBooks();
			//inputStudents();
		}
		
		
			
		public static void Menu(){
	        Scanner in = new Scanner(System.in);
	        System.out.println("Welcome!");
	        System.out.println("What would you like to do?" );
	        System.out.println("---------------------");
	        System.out.println("1. Add new Student");
	        System.out.println("2. Look at current student list and book list");
	        System.out.println("3. Add new book");
	        int a = in.nextInt();
	        if(a==1){
	            newStudent();
	        }
	        else if (a==2) {
	        	loadData();
	        }
	        else if (a==3) {
	           inputBooks();
	         }
	        else{
	            System.out.println("Error: please input the number corresponding to one of the choices.");
	            a = in.nextInt();
	        }
	        in.close();
        
		}
		
		
		private static void newStudent() {
			Scanner in = new Scanner(System.in);
	        
	        System.out.println("Input student first name: ");
	        String a = in.nextLine();
	        while(!a.matches("[a-zA-Z]+"))
	        {
	            System.out.println("Error: first name should not contain numbers.");
	            a = in.nextLine();
	        }
	        
	        System.out.println("Next type the last name of the student: ");
	        String b = in.nextLine();
	        while(!b.matches("[a-zA-Z]+"))
	        {
	            System.out.println("Error: last name should not contain numbers.");
	            b = in.nextLine();
	        }
	       
	        System.out.println("Lastly, type the grade the student is in (1-12): ");
	        int c = in.nextInt();
	        if(c<1 || c>12){
	            System.out.println("Error: grade should be an interger between 1 and 12.");
	             c=in.nextInt();
	        }
	        System.out.println("Which books has the student borrowed? ");
	        String name = in.nextLine();
	        ArrayList<Book> d = booklistSearch(name);
			students.add(new Student(a, b, c, d));
			in.close();
			saveData();
			
		}

		private static ArrayList<Book> booklistSearch(String n) {
			Scanner in = new Scanner(System.in);
			boolean found= false;
			int i=0;
			ArrayList<Book> temp = new ArrayList<Book>();
			while(found==false) {
				 if(n.toLowerCase()==books.get(i).getBname().toLowerCase()) {
					 found= true;
					 System.out.println("Is this the book? ");
					 System.out.println(books.get(i));
					 System.out.println("-----------------------");
					 System.out.println("1. Yes  " + "| 2. No  ");
					 String answer = in.next();
					 
					 if(answer=="1") {
					 temp.add(books.get(i));
					 }
					 else if(answer=="2") {
						 System.out.println("Would you like to quit? ");
					     System.out.println("1. Yes  " + "| 2. No  ");
					     String k = in.next();
					     if(k=="1") {
					    	 Runtime.getRuntime().exit(0);
					     }
					     else if(k=="2") {
						 System.out.println("--------------------");
						 System.out.println("Type the name of the book again: ");
						 String a = in.nextLine();
						 booklistSearch(a);
					     }
					 }
					 else {
						 System.out.println("Error: Please type the number of your choice.");
						 answer=in.next();
					 }
					 
				 }
			}
			in.close();
			return temp;
			
		}

		private static void inputBooks(){
			/*books.add(new Book("Computer Science Illuminated Sixth Edition", "Nell Dale and John Lewis", "9781284055917"));  
	    	books.add(new Book("Higher Level Mathematics Analysis and Approaches", "Ibrahim Wazir and Tim Garry", "9780435193423"));
	    	books.add(new Book("Business Management 4th Edition", "Paul Hoang", "9781921917905"));
	    	books.add(new Book("Theory of Knowledge Second Edition", "Richard van de Lagemaat", "9781107612112"));*/
			Scanner input = new Scanner(System.in);  
		       System.out.println("---------------------");
		       System.out.println("Book name: ");
		       String n = input.nextLine();
		       System.out.println("---------------------");
		       System.out.println("Author: ");
		       String auth = input.nextLine();
		       System.out.println("---------------------");
		       System.out.println("ISBN: ");
		       String ISBN = input.nextLine();
		       while(ISBN.matches("[a-zA-Z]+"))
		       {
		           System.out.println("Error: ISBN should not contain letters.");
		           ISBN = input.nextLine();
		       }
		       System.out.println("---------------------");
		       System.out.println("Confirmation: ");
		       System.out.println("Book name: " + n);
		       System.out.println("Author: " + auth);
		       System.out.println("ISBN : " + ISBN);
		       System.out.println("---------------------");
		       System.out.println("Is that correct? ");
		       System.out.println("1. Yes   "+ "2. No " + "(Type out number of your corresponding to your answer)");
		       String ans = input.next();
		       if(ans.equals("1")) {
		       books.add(new Book(n, auth, ISBN));
		       System.out.println("Book has been added!");
		       }
		       else if (ans.equals("2")) {
		       Menu();
		       }
		       else {
		    	   System.out.println("Please type a valid input.");
		    	   ans = input.next();
		       }
		       input.close();
		       saveData();
		}

		
		private void inputStudents(){
			ArrayList<Book> booklist1 = new ArrayList<Book>();
			ArrayList<Book> booklist2 = new ArrayList<Book>();
			booklist1.add(books.get(2));
			booklist1.add(books.get(1));
			students.add(new Student("John", "Doe", 11, booklist1));
		    booklist2.add(books.get(0));
		    booklist2.add(books.get(3));
			students.add(new Student("Amy", "Smith", 10, booklist2));
		}

		
		public static void saveData(){
		
			
			data.add(books);
			data.add(students);
			

			try {
				FileOutputStream fileOut = new FileOutputStream("data.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(data);
				out.close();
				fileOut.close();
				System.out.println("Serialized data is saved in data.ser");

			} catch(IOException i){
				i.printStackTrace();
			}
		}

		
		
		public static void loadData(){
			Scanner input = new Scanner(System.in);
			

			try {
				FileInputStream fileIn = new FileInputStream("data.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				deserialized = (ArrayList<Object>)in.readObject();
				in.close();
				fileIn.close();
			} catch(IOException i  ){
				i.printStackTrace();
				
			} catch(ClassNotFoundException c){
				c.printStackTrace();
				
			} catch(NullPointerException e) {
				e.printStackTrace();	
			
		}
			
			ArrayList<Book>retrievedBooklist = (ArrayList<Book>)deserialized.get(0);
			ArrayList<Student> retrievedStudentlist = (ArrayList<Student>)deserialized.get(1);
			System.out.println("Would you like to view the student list? ");
			System.out.println("1. Yes  |  2. No ");
			int ans = input.nextInt();
			if(ans==1) {
			System.out.println("--------------------");
	    	System.out.println("Student profiles:");
	    	System.out.println("--------------------");
	    	for(int i = 0; i<retrievedStudentlist.size();i++) {
	    		System.out.println((i+1) + ". " + retrievedStudentlist.get(i).getFname() + " " 
	    	+ retrievedStudentlist.get(i).getLname() + " Grade: " + retrievedStudentlist.get(i).getGrade() );
	    		
	    		for(int j=0; j<retrievedStudentlist.get(i).getBooks().size(); j++){
					System.out.println( "Borrowed books:"+ retrievedStudentlist.get(i).getBooks().get(j).getBname());
				}
	    		System.out.println("--------------------");
	    	  }
			}
			else if(ans != 1 || ans != 2) {
				System.out.println("Please type the number corresponding to the choice.");
				ans = input.nextInt();
			}
			System.out.println("____________________________");
			System.out.println("Would you like to view the book list? ");
			System.out.println("--------------------");
			System.out.println("1. Yes  |  2. No ");
			int ans1 = input.nextInt();
			if(ans1==1) {
	    	for(int i = 0;i<retrievedBooklist.size();i++ ) {
	    		System.out.println((i+1)+". "+ retrievedBooklist.get(i).getBname()+ " by "+ retrievedBooklist.get(i).getAuthor());
	    	  }
			}
			else if(ans1 == 2) {
				Runtime.getRuntime().exit(0);
			}
			else if(ans1 != 1 || ans1 != 2) {
				System.out.println("Please type the number corresponding to the choice.");
				ans1 = input.nextInt();
			}

	    	input.close();
		}
}
