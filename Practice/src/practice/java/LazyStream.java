package practice.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Counter{
    private long counter;
 
    public void wasCalled() {
        counter++;
        System.out.println("Counter "+counter);
    }
}

public class LazyStream {
   

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Anna", "Bob", "Charlie", "David", "Eve", "Adam"
				, "Brian", "Catherine", "Derek", "Eva", "Anand", "Brent");
        // counter = 0;
        Counter c = new Counter();
       Optional<String> stream = list.stream().filter(element -> {
            System.out.println("filter() was called");
            c.wasCalled();
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();
        
        
        ///////////////////////////////
        String listToString = list.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("List to String: "+listToString);

        Map<Boolean, List<String>> partitionedMap = list.stream().collect(Collectors.partitioningBy(s -> s.startsWith("A")));
        System.out.println(partitionedMap.get(false));
    }

}
