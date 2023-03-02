package javasqlserver;
import java.sql.*;
import java.util.Scanner;
public class javasqlserver1 {
	public static void main(String[] args) {
	    String url = "jdbc:sqlserver://localhost:1433;" +
	            "databaseName=HotelDBMS;" +
	            "encrypt=true;" +
	            "trustServerCertificate=true";
	    
	    
	    String user = "sa";
	    String pass = "root";
	    
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Enter id: ");
	    Integer id = scanner.nextInt();
	    System.out.println("Enter hotel name: ");
	    String name = scanner.next();
	    System.out.println("Enter hotel location: ");
	    String location = scanner.next();
	    System.out.println("Enter created date: ");
	    String date = scanner.next();
	    System.out.println("Enter updated date: ");
	    String date1 = scanner.next();
	    System.out.println("is_Active: ");
	    boolean active = scanner.nextBoolean();
	    
	    
	    //room
//	    System.out.println("Enter id: ");
//	    Integer id = scanner.nextInt();
//	    System.out.println("Enter hotel name: ");
//	    String roomtypename = scanner.next();
//	    System.out.println("Enter created date: ");
//	    String date = scanner.next();
//	    System.out.println("Enter updated date: ");
//	    String date1 = scanner.next();
//	    System.out.println("is_Active: ");
//	    boolean active = scanner.nextBoolean();
//	    
	    
	    
	    
	    
	    Connection con = null;
	    try {
	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);
	        con = DriverManager.getConnection(url, user, pass);
	        Statement st = con.createStatement();
	        
   
		        String sql = "CREATE TABLE Hotels (id INT PRIMARY KEY , " +
		                 "hotel_name VARCHAR(255) NOT NULL, " +
		                 "hotel_location VARCHAR(255), " +
		                 "created_date VARCHAR(255) NOT NULL, " +
		                 "updated_date VARCHAR(255), " +
		                 "is_Active BIT NOT NULL)";
	        
	       st.executeUpdate(sql);
	        	        
	       
	       
	        String sql01= "CREATE TABLE Room_Type ("
	        		 +"id Integer Primary Key,"
	        		 + "room_type_name String not null,"
	        		 + "created_date VARCHAR(250), "
	        		 + "updated_date VARCHAR(250), "
	        		 + "is_Active BIT NOT NULL)";
	        
	        
	        		 st.executeUpdate(sql01);
	       
	        
	        
	        
	        		 String sql02=  "CREATE TABLE Rooms ("
	        				 + " id INTEGER PRIMARY KEY,"
	        				 + " room_type_id INTEGER REFERENCES Room_Type(id),"
	        				 + " hotel_id INTEGER REFERENCES Hotels(id),"
	        				 + " created_date VARCHAR(255) NOT NULL,"
	        				 + " updated_date VARCHAR(255),"
	        				 + " is_active BIT NOT NULL"
	        				 + ")";
	    	        
	    	        
	    	        		 st.executeUpdate(sql02);
	    	        		 
	    	        		 
	    	        		 
	    	        		 
	    	        		 
	    	        		 
	    	        		 String sql03= " CREATE TABLE Guests ("
	    	        		 + " id INTEGER PRIMARY KEY,"
	    	        		 + " guest_name TEXT NOT NULL,"
	    	        		 + " guest_phone TEXT NOT NULL,"
	    	        		 + " guest_accompanying_members INTEGER NOT NULL,"
	    	        		 + " guest_payment_amount INTEGER NOT NULL,"
	    	        		 + " room_id INTEGER REFERENCES Rooms(id),"
	    	        		 + " hotel_id INTEGER REFERENCES Hotels(id),"
	    	        		 + " created_date VARCHAR(255) NOT NULL,"
	    	        		 + " updated_date VARCHAR(255),"
	    	        		 + " is_active BIT NOT NULL"
	    	        		 + ")";
	    	        		 
	    	        		 
	    	        		 st.executeUpdate(sql03);
	    	        		 
	    	        		 
	    	        		 
	    	        		 String sql04=" CREATE TABLE Employee_Type ("
	    	        		 + " id INTEGER PRIMARY KEY,"
	    	        		 + " employee_type_name TEXT NOT NULL,"
	    	        		 + " created_date VARCHAR(255) NOT NULL,"
	    	        		 + " updated_date VARCHAR(255),"
	    	        		 + " is_active BIT NOT NULL"
	    	        		 + ")";
	    	        		 
	    	        		 
	    	        				 st.executeUpdate(sql04);
	    	        		 
	        
	    	        				 
	    	        				 
	    	        				 
	    	        				 
	    	        				 String sql05= " CREATE TABLE Employees (\r\n"
	    	        				 + " id INTEGER PRIMARY KEY,"
	    	        				 + " employee_name TEXT NOT NULL,"
	    	        				 + " employee_phone TEXT NOT NULL,"
	    	        				 + " employee_type_id INTEGER REFERENCES Employee_Type(id),"
	    	        				 + " room_id INTEGER REFERENCES Rooms(id),"
	    	        				 + " created_date VARCHAR(255) NOT NULL,"
	    	        				 + " updated_date VARCHAR(255),"
	    	        				 + " is_active BIT NOT NULL"
	    	        				 + ")";
	    	        				 
	    	        				 
	    	        				 
	    	        				 
	    	        				 st.executeUpdate(sql05);
	    	        		 
	    	        		 
	    	        		 
	        		 
	        
	        
	        String sql0 = "INSERT INTO Hotels (id, hotel_name, hotel_location, created_date, updated_date, is_Active) VALUES('" + id
	            + "','" + name + "','" + location + "','" + date + "','" + date1 + "','" + active + "')";

	        int m = st.executeUpdate(sql0);

	        if (m >= 1) {
	            System.out.println("inserted successfully : " + sql0);
	        } else {
	            System.out.println("insertion failed");
	        }

	        String sql1 = "SELECT * FROM Hotels";

	        ResultSet resultSet = st.executeQuery(sql1);
	        while (resultSet.next()) {
	            System.out.println(resultSet.getString("id"));
	            System.out.println(resultSet.getString("hotel_name"));
	            System.out.println(resultSet.getString("hotel_location"));
	            System.out.println(resultSet.getString("created_date"));
	            System.out.println(resultSet.getString("updated_date"));
	            System.out.println(resultSet.getString("is_Active"));
	        }
	        

	        con.close();
	    } catch (Exception ex) {
	        System.err.println(ex);
	    }
	}
}