package start.streams_demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    
    public static void main(String[] args) {
        
         List<String> listNames = Arrays.asList("Aman", "Naman", "Shravan", "Dhavan", "Ayan");

        Optional<String> res = listNames.stream().reduce((x, y) -> x + ", "+ y);
        System.out.println(res.get());

         // streams can not be reused after terminal operation is applied
        Stream<String> streamName = listNames.stream();
        streamName.forEach(System.out::println);
        // streamName.map(String::toUpperCase).collect(Collectors.toList());       // Can not do this after above line

        // forEachOrdered
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Parallel stream using forEach : ");
        nums.parallelStream().forEach(System.out::println);
        System.out.println("Parallel stream using forEachOrdered : ");
        nums.parallelStream().forEachOrdered(System.out::println);

    }
}
