package practice.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SimpleJdbcExample {

    // JDBC Driver and Connection URL (Using SQLite for simplicity)
    private static final String JDBC_URL = "jdbc:sqlite:memory:"; 
    // private static final String JDBC_URL = "jdbc:mysql://localhost:3306/database_name"; 
    private static final String username = "rootgfg"; // MySQL credentials
    private static final String password = "gfg123";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // STEP 1: Load the Driver (Modern Java often handles this automatically)
            // Class.forName("org.sqlite.JDBC"); 
        //     String classpath = System.getProperty("java.class.path");
        // System.out.println("Runtime Classpath:");
        // // In Windows, paths are separated by semicolons; in Linux/macOS, by colons.
        // for (String path : classpath.split(System.getProperty("path.separator"))) {
        //     System.out.println("  -> " + path);
        // }


            try {
                // Class.forName("com.mysql.cj.jdbc.Driver");
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                System.err.println("SQLite driver class not found! Check your classpath configuration.");
                e.printStackTrace();
                return; // Exit the application if driver is not found
            }

            
            System.out.println("JDBC Driver loaded.");

            // STEP 2: Establish the Connection
            connection = DriverManager.getConnection(JDBC_URL, username, password);
            System.out.println("Connection established.");

            // STEP 3: Create a Statement
            statement = connection.createStatement();

            // Setup: Create a table and insert data
            String createTableSQL = "CREATE TABLE Employees (id INT, name VARCHAR(50), salary INT)";
            statement.executeUpdate(createTableSQL);
            
            String insertDataSQL = "INSERT INTO Employees VALUES (1, 'Alice', 60000), (2, 'Bob', 75000)";
            statement.executeUpdate(insertDataSQL);
            System.out.println("Table created and data inserted.");

            // STEP 4: Execute the Query
            String selectDataSQL = "SELECT id, name, salary FROM Employees WHERE salary > 50000";
            resultSet = statement.executeQuery(selectDataSQL);

            System.out.println("\n--- Results ---");
            // STEP 5: Process the Results
            while (resultSet.next()) {
                // Retrieve by column name or index
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");

                System.out.printf("ID: %d, Name: %s, Salary: %d%n", id, name, salary);
            }

        } catch (SQLException e) {
            System.err.println("SQL Error occurred: " + e.getMessage());
        } finally {
            // STEP 6: Close Resources in a 'finally' block to ensure they are released
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("\nResources closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
