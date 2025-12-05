package start.java_beans_demo;

import java.io.Serializable;

public class StudentBean implements Serializable{
    
    public static final long serializableUID = 1L;

    private String name;
    private int age;
    private int rollno;

    // no args constructor will be provided bydefault
    
    
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
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + rollno;
    }
    
}
