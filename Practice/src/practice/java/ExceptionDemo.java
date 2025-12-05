package practice.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo{

    public static void readFile(String filePath) {
        
        // Resource declaration within the parentheses.
        // The BufferedReader is automatically closed after the block, 
        // even if an exception occurs.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            System.out.println("--- File Content ---");
            
            // Read lines until the end of the file (null)
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            // Handle exceptions related to file reading or opening
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
        
        // At this point, the 'reader' resource is guaranteed to be closed.
        System.out.println("--------------------");
    }

    public static void main(String[] args){
        
        readFile("D:\\Coding\\Web\\demo\\Java\\Practice\\src\\practice\\java\\problems");
    }
}