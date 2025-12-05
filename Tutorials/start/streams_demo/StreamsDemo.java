package start.streams_demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class StreamsDemo {

    // What is stream ?
    // it is the sequence of elements supporting functional and declerative
    // programming

    // how to use stream ?
    // Source -> intermediate operation -> terminal operations

    public static void main(String[] args) {

        // Creating streams
        // 1. from Collections
        List<Integer> lst1 = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = lst1.stream();

        // 2. from arrays
        String[] array1 = { "a", "b", "s", "f", "e" };
        Stream<String> stream2 = Arrays.stream(array1);

        // 3. Using Stream.of()
        Stream<String> stream3 = Stream.of("a", "d", "g", "e");

        // 4. Infinite stream (limit can be added using limit(int count))
        Stream<Integer> stream4 = Stream.generate(() -> 1 * 1);// .limit(20);
        // Stream<Integer> stream5 =
        List<Integer> lstIterate = Stream.iterate(1, x -> (x + 1)).limit(20).collect(Collectors.toList());
        System.out.println(lstIterate);
    }
}
