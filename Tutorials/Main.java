import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

import start.CustomAnnotation;
import start.EnumTutorial;
import start.serialize_demo.Student;

public class Main {

    @CustomAnnotation(value = 88)
    public void hello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\n=======================================================");
        ///////////////////////////////// Tutorial - 1
        EnumTutorial c1 = EnumTutorial.RED;

        System.out.println("Red enum name : " + c1.name());
        System.out.println("Red enum value : " + c1.getValue());

        for (EnumTutorial color: EnumTutorial.values()){
            System.out.println("Enum values : "+ color.getValue());
        }

        System.out.println("\n=======================================================");
        ///////////////////////////////// Tutorial - 2 : Custom Annotation
        Main obj = new Main();
        Method mVal = obj.getClass().getMethod("hello");

        CustomAnnotation annotationObj = mVal.getAnnotation(CustomAnnotation.class);
        System.out.println("Annotation value : " + annotationObj.value());


        System.out.println("\n=======================================================");
        ///////////////////////////////// Tutorial - 3 : Serializable
        Student st1 = new Student("Kishor", 29, 17);
        st1.setX(99);

        String fileName = "D:\\Coding\\Web\\demo\\Java\\Tutorials\\SerializableDemo.txt";
        FileOutputStream fOut = null;
        ObjectOutputStream objOut = null;

        try{  // Serialization
            fOut = new FileOutputStream(fileName);
            objOut = new ObjectOutputStream(fOut);
            objOut.writeObject(st1);

            objOut.close();
            fOut.close();

            System.out.println("Student object has been serialized : " + st1);
            System.out.println("Transient variable value before Serialization : " + st1.getX());
        } catch (IOException e) {
            System.out.println("IOException : File not found");
        }

        FileInputStream fIn = null;
        ObjectInputStream objIn = null;

        try {   // Deserialization
            fIn = new FileInputStream(fileName);
            objIn = new ObjectInputStream(fIn);

            Student stObj = (Student) objIn.readObject();

            System.out.println("Student object has been deserialized : "+ stObj);
            System.out.println("Transient Variable value after Deserialization : " + stObj.getX());

            objIn.close();
            fIn.close();
        } catch (IOException e) {
            System.out.println("IOException : File not found");
        } catch (ClassNotFoundException cn) {
            System.out.println("ClassNotFoundException is caught");
        }

        fileName.contains("s");


    }
}
