package start.imagehandling_demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandlingDemo {

    public static void main(String[] args) {
        
        int width = 963;
        int height = 640;

        BufferedImage image = null;

        image = readFromFile(width, height, image);

        writeToFile(image);
    }
    
    private static BufferedImage readFromFile(int width, int height, BufferedImage image) {

        try {
            File imageFile = new File("D:\\WIN\\autumn_leaves.png");

            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // reading input
            image = ImageIO.read(imageFile);

            System.out.println("Reading Complete : " + image);
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }

        return image;
    }

    public static void writeToFile(BufferedImage imagee) {
        try {
            File imageOut = new File("D:\\Coding\\Web\\demo\\Java\\Tutorials\\assets\\imageOut.png");

            ImageIO.write(imagee, "png", imageOut);

            System.out.println("Writing Complete");
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }
    }
}
