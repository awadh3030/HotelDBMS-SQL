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
	       
	        
	        
	        
	        		 String sql02= "CREATE TABLE Room ("
	    	        		 +"id Integer Primary Key,"
	    	        		 + "room_type_name String not null,"
	    	        		 + "created_date VARCHAR(250), "
	    	        		 + "hotel_id Integer Foriegn key, "
	    	        		 + "updated_date VARCHAR(250), "
	    	        		 + "is_Active BIT NOT NULL)";
	    	        
	    	        
	    	        		 st.executeUpdate(sql02);
	        
	    	        		 
	    	        		 
	    	        		 
	        		 
	        
	        
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