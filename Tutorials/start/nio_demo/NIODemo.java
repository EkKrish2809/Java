package start.nio_demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIODemo {
    
    public static void main(String[] args) throws IOException{

        // test this seprately from write example
        FileInputStream fin = new FileInputStream("D:\\Coding\\Web\\demo\\Java\\Tutorials\\assets\\FileStreaDemo.txt");
        FileChannel readChannel = fin.getChannel();
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int result = readChannel.read(readBuffer);
        System.out.println("File read successfully " + result);
        fin.close();

        // test this seprately from read example
        FileOutputStream fout = new FileOutputStream("D:\\Coding\\Web\\demo\\Java\\Tutorials\\assets\\dest.txt");
        FileChannel writeChannel = fout.getChannel();
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        String message = "This is a test string";
        writeBuffer.put(message.getBytes());
        writeBuffer.flip();
        writeChannel.write(writeBuffer);
        System.out.println("file written successfully");
        fout.close();
    }
}
