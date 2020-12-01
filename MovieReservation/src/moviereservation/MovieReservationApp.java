package moviereservation;

//STEP 1. Import required packages
import java.sql.*;
import java.util.*;
import java.io.Console;

public class MovieReservationApp {
   // JDBC driver name and database URL
   
   static final String DB_URL = "jdbc:mysql://localhost/movie_reservation?serverTimezone=UTC"; // DATABASE LOCATION HERE
   
   static final String USER = "root"; // ENTER USERNAME HERE
   static final String PASS = ""; // ENTER PASSWORD HERE
   
   public Connection conn = null; // connection used to access database
   public Statement stmt = null; // statement that is sent to the database to be executed

   
   
   // inserts a movie into the database
   // takes parameters of the movie name, movie year, and movie length
   public void insertMovie(String name, int year, int length) {
	   String sqlFormatName = "'" + name + "'";
	   ResultSet rs = null;
	  try {
		  this.stmt = this.conn.createStatement();
		  this.stmt.executeUpdate("INSERT INTO Movies " + "VALUES ("
				  + "2, " + sqlFormatName + ", " + year + ", " + length + ")");
		  rs = this.stmt.executeQuery("SELECT * FROM Movies");
	   
	      while(rs.next()){
	          System.out.println("mID="+rs.getInt("mID")+", name="+rs.getString("name") + ", year="+rs.getInt("year")
	          + ", length=" + rs.getInt("length"));
	      }
	      
	      this.stmt = null;
	     
	  } catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
   }
   
   // inserts a movie into the database
   // parameter is a movie (class that contains mID, name, year, and length)
   public void insertMovie(Movie movie) {
	   String sqlFormatName = "'" + movie.getName() + "'";
	   ResultSet rs = null;
	  try {
		  this.stmt = this.conn.createStatement();
		  this.stmt.executeUpdate("INSERT INTO Movies " + "VALUES ("
				  + "2, " + sqlFormatName + ", " + movie.getYear() + ", " + movie.getLength() + ")");
		  rs = this.stmt.executeQuery("SELECT * FROM Movies");
	   
	      while(rs.next()){
	          System.out.println("mID="+rs.getInt("mID")+", name="+rs.getString("name") + ", year="+rs.getInt("year")
	          + ", length=" + rs.getInt("length"));
	      }
	      
	      this.stmt = null;
	     
	  } catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
   }
   
   // connects to the database with the username and password given
   public void connectToDatabase() {
	   try {
		   this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
	   } catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
   }
   
   
   // main function
   public static void main(String[] args) {
	   String userInput = "";
	   Scanner sc = new Scanner(System.in);
	   MovieReservationApp mrp = new MovieReservationApp();
	   
	   System.out.println("Welcome to the Movie Theater Reservation!");
	   System.out.println("Here are the following options:");
	   System.out.println("C - Create a new account");
	   System.out.println("L - Log into your account");
	   System.out.println("Q - Quit");
	   
	   userInput = sc.nextLine();
	   
	   while(userInput != "Q") {
		   if(userInput.toUpperCase().equals("C")) {
			   System.out.println("Please enter a username");
			   String username = sc.nextLine();
			   System.out.println("Please enter a password");
			   String password = sc.nextLine();
			   System.out.println("Please enter the password again");
			   String passwordConfirmed = sc.nextLine();
			   if(!password.equals(passwordConfirmed)) {
				   passwordConfirmed = "";
				   System.out.println("Passwords didn't match, please try again");
				   passwordConfirmed = sc.nextLine();
			   } else { // send data to database and send user back 
				   System.out.println("Your account has been created!");
				   System.out.println("-------------------------------------");
				   System.out.println("Here are the following options:");
				   System.out.println("C - Create a new account");
				   System.out.println("L - Log into your account");
				   System.out.println("Q - Quit");
				   userInput = sc.nextLine();
			   }
			   
		   } else if(userInput.toUpperCase().equals("L")) { // connect to database and verify user
			   String userTypeInput = "";
			   System.out.println("Please choose one of the following:");
			   System.out.println("U - User");
			   System.out.println("A - Admin");
			   System.out.println("B - Back to home screen");
			   userTypeInput = sc.nextLine();
			   if(userTypeInput.toUpperCase().equals("U")) {
				   System.out.println("Please enter your username");
				   String username = sc.nextLine();
				   System.out.println("Please enter your password");
				   String password = sc.nextLine();
				   // connect to database and verify 
			   } else if(userTypeInput.toUpperCase().equals("A")) {
				   
			   } else if(userTypeInput.toUpperCase().equals("B")) {
				   System.out.println("-------------------------------------");
				   System.out.println("Here are the following options:");
				   System.out.println("C - Create a new account");
				   System.out.println("L - Log into your account");
				   System.out.println("Q - Quit");
				   userInput = sc.nextLine();
			   } else {
				   System.out.println(userInput + " is an invalid option.");
				   System.out.println("Here are the following options: ");
				   System.out.println("C - Create a new account");
				   System.out.println("L - Log into your account");
				   System.out.println("Q - Quit");
				   userInput = sc.nextLine();
			   }
			   
		   } else if(userInput.toUpperCase().equals("Q")) {
			   sc.close();
			   System.out.println("Thank you for using the Movie Theater Reservation!");
			   System.out.println("Goodbye!");
			   return;
			   
		   } else {
			   System.out.println(userInput + " is an invalid option.");
			   System.out.println("Here are the following options: ");
			   System.out.println("C - Create a new account");
			   System.out.println("L - Log into your account");
			   System.out.println("Q - Quit");
			   userInput = sc.nextLine();
		   }
	   } 
	   
	   
	   
	   

	   try{

		   //STEP 3: Open a connection
		   System.out.println("Connecting to database...");
		   mrp.connectToDatabase();

		   System.out.println("Connected!");
     
      
	   } catch(Exception e){
		   //Handle errors for Class.forName
		   e.printStackTrace();
	   }
   System.out.println("Goodbye!");
   sc.close();
   }//end main
}//end JDBCExample