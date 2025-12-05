package start.io_streams_demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
    
    public static void main(String[] args) throws IOException{
        FileInputStream fileInStream = null;
        FileOutputStream fileOutStream = null;

        try {
            fileInStream = new FileInputStream("D:\\Coding\\Web\\demo\\Java\\Tutorials\\assets\\FileStreaDemo.txt");
            fileOutStream = new FileOutputStream("D:\\\\Coding\\\\Web\\\\demo\\\\Java\\\\Tutorials\\\\assets\\\\FileStreaDemoOut.txt");

            // reading one byte at a time
            int content;
            while((content = fileInStream.read()) != -1) {
                fileOutStream.write((byte) content);
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
