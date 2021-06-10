import java.util.Scanner;
public class GradebookEntryAssignment {
	
	private static Scanner keyboard = new Scanner (System.in);
	private static String firstname;
	private static String lastname; 
	private static String address;
	private static String phone;
	private static String grade;
	private static String firstassignment;
	private static double pointsearned1; 
	private static double pointspossible1; 
	private static String secondassignment;
	private static double pointsearned2;
	private static double pointspossible2;
	private static String thirdassignment;
	private static double pointsearned3;
	private static double pointspossible3;
	private static double totalearned;
	private static double totalpossible;
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Please enter your first name ");
		firstname = keyboard.nextLine ();
		System.out.print ("Please enter your last name ");
		lastname = keyboard.nextLine ();
		System.out.print ("Please enter your address ");
		address = keyboard.nextLine ();
		System.out.print ("Please enter your phone number ");
		phone = keyboard.nextLine ();
		System.out.print ("Please enter your grade ");
		grade = keyboard.nextLine ();
		System.out.print ("First Assginment Name ");
		firstassignment = keyboard.nextLine ();
		System.out.print ("Points Earned ");
		pointsearned1 = Double.valueOf(keyboard.nextLine());
		System.out.print ("Points Possible ");
		pointspossible1 = Double.valueOf(keyboard.nextLine());
		System.out.print ("Second Assginment Name ");
		secondassignment = keyboard.nextLine();
		System.out.print ("Points Earned ");
		pointsearned2 = Double.valueOf(keyboard.nextLine());
		System.out.print ("Points Possible ");
		pointspossible2 = Double.valueOf(keyboard.nextLine());
		System.out.print ("Third Assginment Name ");
		thirdassignment = keyboard.nextLine();
		System.out.print ("Points Earned ");
		pointsearned3 = Double.valueOf(keyboard.nextLine());
		System.out.print ("Points Possible ");
		pointspossible3 = Double.valueOf(keyboard.nextLine());
		System.out.println(firstname + " " +lastname + " " + address);
		System.out.println("Grade " + grade + " contact: " + phone);
		System.out.println(firstassignment + ": " + pointsearned1 + "/" + pointspossible1 + " : " + String.format("%.1f", (pointsearned1/pointspossible1*100)) + "%");
		System.out.println(secondassignment + ": " + pointsearned2 + "/" + pointspossible2 + " : " + String.format("%.1f", (pointsearned2/pointspossible2*100)) + "%");
		System.out.println(thirdassignment + ": " + pointsearned3 + "/" + pointspossible3 + " : " + String.format("%.1f", (pointsearned3/pointspossible3*100)) + "%");
		totalearned = pointsearned1+pointsearned2+pointsearned3;
		totalpossible = pointspossible1+pointspossible2+pointspossible3;
		System.out.println("Total: " + totalearned + "/" + totalpossible + "    Average: " + (totalearned/totalpossible*100) + "%");
	}

}
