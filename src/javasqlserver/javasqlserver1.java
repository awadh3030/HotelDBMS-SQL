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

 Connection con = null;
        try {
Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);
 Statement st = con.createStatement();
 
 String sql = "CREATE TABLE Hotels (id INT PRIMARY KEY IDENTITY, " +
		 "hotel_name VARCHAR(255) NOT NULL, " +
		 "hotel_location VARCHAR(255), " +
		 "created_date DATE NOT NULL, " +
		 "updated_date DATE, " +
		"is_Active BIT NOT NULL)";
 
 
 String sql0 = "insert into Hotels values('" + id
+ "'," + name + ",'" + location + ",'" + date +",'" + date1+"'+,'" + active+"' )";
Integer m = st.executeUpdate(sql0);
            if (m >= 1) {
System.out.println("inserted successfully : " + sql);
} else {
System.out.println("insertion failed");
}
            String sql1 = "Select * from Table_1";
ResultSet resultSet = st.executeQuery(sql1);
             while (resultSet.next()) {
            	 System.out.println(resultSet.getString("id"));
            	 System.out.println(resultSet.getString("name"));
            	 System.out.println(resultSet.getString("location"));
            	 System.out.println(resultSet.getString("date"));
            	 System.out.println(resultSet.getString("date1"));
            	 System.out.println(resultSet.getString("active"));
}
            con.close();
} catch (Exception ex) {
System.err.println(ex);
}
}
}