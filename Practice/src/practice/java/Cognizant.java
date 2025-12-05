package practice.java;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Cognizant {
    
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("AA", "BB", "CC", "AA");

        System.out.println(strList.stream().collect(Collectors.groupingBy(s-> s, TreeMap::new, Collectors.counting())));
    }
}
