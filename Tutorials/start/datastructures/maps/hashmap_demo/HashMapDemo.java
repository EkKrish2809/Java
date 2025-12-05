package start.datastructures.maps.hashmap_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapDemo {
    
    public static void main(String[] args) {
        
        HashMap<Student, Integer> map = new HashMap<>();
        Student st1 = new Student("Adam", 1);
        Student st2 = new Student("Faiz", 2);
        Student st3 = new Student("Atul", 3);
        Student st4 = new Student("Salman", 4);
        Student st5 = new Student("Atul", 3);

        map.put(st1, 88);
        map.put(st2, 82);
        map.put(st3, 78);
        map.put(st4, 98);
        map.put(st5, 70);

        for (Map.Entry<Student, Integer> st : map.entrySet()) {
            System.out.println(st.getKey() + " ->" + st.getValue());
        }
    }

}

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()){
            return false;
        }
        Student st = (Student)obj;
        return id == st.getId() && Objects.equals(name, st.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString(){
        return this.getName() + ": (" + this.getId() + ")";
    }
}