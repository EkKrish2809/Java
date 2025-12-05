package start.streams_demo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsDemo {
    
    public static void main(String[] args) {
        List<String> listNames = Arrays.asList("Aman", "Naman", "Shravan", "Dhavan", "Ayan", "Naman");

        // 1. collecting to a list
        List<String> names = listNames.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(names);

        // 2. collecting to a set
        Set<String> uniqueNames = listNames.stream().map(String::toUpperCase).collect(Collectors.toSet());
        System.out.println(uniqueNames);

        // 3. collecting to a specific collection
        ArrayDeque<String> arrayDeq = listNames.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        System.out.println(arrayDeq);

        // 4. joining strings
        String combinedString = listNames.stream().collect(Collectors.joining("-> "));
        System.out.println(combinedString);

        // 5. summarizing data
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        IntSummaryStatistics stats =nums.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count : " +stats.getCount());
        System.out.println("Average : " +stats.getAverage());
        System.out.println("Max : " +stats.getMax());
        System.out.println("Max : " +stats.getMax());
        System.out.println("Sum : " +stats.getSum());

        // 6. Grouping elements
        System.out.println(listNames.stream().collect(Collectors.groupingBy(x -> x.length())));
        System.out.println(listNames.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.counting())));
        System.out.println(listNames.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        System.out.println(listNames.stream().collect(Collectors.groupingBy(x -> x.length(), TreeMap::new, Collectors.counting())));
        System.out.println(listNames.stream().collect(Collectors.groupingBy(x -> x, TreeMap::new, Collectors.counting())));

        // from interview
        List<String> alphabets = Arrays.asList("AA", "BB", "CC", "AA");
        System.out.println(alphabets.stream().collect(Collectors.groupingBy(x->x, TreeMap::new, Collectors.counting())));
        System.out.println(alphabets.stream().collect(Collectors.groupingBy(x->x, Collectors.counting())));

        // 7. partitioning by
        System.out.println(listNames.stream().collect(Collectors.partitioningBy(x -> x.startsWith("N"))));

        // 8. Creating a map from Stream elements
        System.out.println(alphabets.stream().collect(Collectors.toMap(x -> x.toUpperCase(), count -> 1, (x,y) -> x+y)));
    }
}
