package practice.java;

public class Overloading {
    
    public static void myPrint(String s){
        System.out.println("String");
    }

    public static void myPrint(Object o){
        System.out.println("Object");
    }

    // public static void myPrint(Integer i){
    //     System.out.println("Integer");
    // }

    public static void main(String[] args) {
        myPrint(null);
    }
}
