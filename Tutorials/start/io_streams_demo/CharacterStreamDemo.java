package start.io_streams_demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo {
    
     public static void main(String[] args) throws IOException{
        FileReader fileInStream = null;
        FileWriter fileOutStream = null;

        try {
            fileInStream = new FileReader("D:\\Coding\\Web\\demo\\Java\\Tutorials\\assets\\FileStreaDemo.txt");
            fileOutStream = new FileWriter("D:\\Coding\\Web\\demo\\Java\\Tutorials\\assets\\FileReaderDemoOut.txt");

            // reading one byte at a time
            int content;
            while((content = fileInStream.read()) != -1) {
                fileOutStream.write((char) content);
            }
        // } catch (IOException e) {
        //     System.out.println(e);
        } finally {
            if (fileInStream != null){
                fileInStream.close();
            }
            if (fileOutStream != null){
                fileOutStream.close();
            }
        }
    }
}
