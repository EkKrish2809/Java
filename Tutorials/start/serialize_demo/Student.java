package start.serialize_demo;

import java.io.Serializable;

public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private int rollNumber;
    
    transient int x;
    
    public Student(String name, int age, int rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    @Override
    public String toString() {
        return ("Student Name = " + this.getName() + 
        "\tAge = " + this.getAge() + 
        "\tRoll No. = " + this.getRollNumber());
    }    
    
}
