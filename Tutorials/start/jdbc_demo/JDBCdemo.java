package start.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {
    
    public static void main(String[] args) throws SQLException{
        // String url = "jdbc:postgresql://localhost/test";
        String url = "jdbc:sqlite:mydatabase.db";
        Connection pgConn = null;

        int rollNo = 1;
        String name = "Kishor";
        int age = 29;
        String sql = "insert into student(rollno, name, age) " + "values(" + rollNo + ", '" + name + "', " + age + ")";
        String sqlSelect = "select * from student";

        try {
            Class.forName("org.sqlite.JDBC"); // only for Sqlite
            // pgConn = DriverManager.getConnection(url, "user", "pass");
            pgConn = DriverManager.getConnection(url);
            Statement st = pgConn.createStatement();

            // comment one of the below operations while studying and testing
            System.out.println("Inserting into database...");
            int m = st.executeUpdate(sql);
            if (m == 1){
                System.out.println("Query executed successfully : " + sql);
            } else {
                System.out.println("Query execution failed : " + m);
            }

            System.out.println("Querying database...");
            // Execute the query and get the ResultSet
            ResultSet resultSet = st.executeQuery(sqlSelect);
            // 2. Iterate and Print the Data
            printResultSet(resultSet);

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            pgConn.close();
        }
    }

    // ----------------------------------------------------
    
    /**
     * Iterates through the ResultSet and prints each row.
     */
    private static void printResultSet(ResultSet resultSet) throws SQLException {
        
        System.out.println("\n--- Student Records ---");
        System.out.printf("%-8s %-15s %-5s%n", "Roll No", "Name", "Age");
        System.out.println("---------------------------------");
        
        // The .next() method moves the cursor to the next row and returns true if a row exists
        while (resultSet.next()) {
            
            // Retrieve data from the current row by column name (or index)
            int rollNo = resultSet.getInt("rollno");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            
            // Print the data in a formatted way
            System.out.printf("%-8d %-15s %-5d%n", rollNo, name, age);
        }
        System.out.println("---------------------------------");
    }
}
