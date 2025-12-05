package start.streams_demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {
    
    public static void main(String[] args) {
        // intermediate operations transform one Stream to another Stream
        // they are lazy, meaning they don't execute until terminal operation is executed

        // 1. filter (takes Predicate i.e. checks the condition and returns boolean result)
        List<String> listNames = Arrays.asList("Aman", "Naman", "Shravan", "Dhavan", "Ayan");
        listNames.stream().filter(x -> x.startsWith("A"));  // actual filtering won't happen here

        // applying terminal operation
        long nameCount = listNames.stream().filter(x -> x.startsWith("A")).count();
        System.out.println(nameCount);

        // 2. map (Takes Function i.e. converts the stream based on operation requested)
        Stream<String> namesUpperCase = listNames.stream().map(x -> x.toUpperCase());
        Stream<String> namesUpperCase1 = listNames.stream().map(String::toUpperCase);

        // 3. sorted (sorts the stream by natural ordering and also custom sorting logic can be added )
        listNames.stream().sorted();    // natural order sorting eg. number sequence, alphabets
        listNames.stream().sorted((a,b) -> a.length() - b.length());

        // 4. distinct (removed multiple occurance of elements in stream and keeps unique occurances)
        System.out.println(listNames.stream().filter(x -> x.startsWith("A")).distinct().count());

        // 5. limit
        Stream<Integer> lstIterate = Stream.iterate(1, x -> (x + 1)).limit(20);

        // 6. skip
        Stream<Integer> lstIterateSkip = Stream.iterate(1, x -> (x + 1)).skip(10).limit(20);


        //
        List<String> sentences = Arrays.asList(
            "Hello world",
            "Java Streams are powerful",
            "flatmap is useful"
        );

        System.out.println(sentences.stream()
                                    .flatMap(x -> Arrays.stream(x.split(" ")))
                                    .map(String::toUpperCase)
                                    .collect(Collectors.toList()));
    }
}
