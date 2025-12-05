package start.streams_demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PArallelStreamDemo {
    
    public static void main(String[] args) {

        // Problem : Find the factorial of numbers in list
        List<Integer> listnums = Stream.iterate(1, x -> x+1).limit(10000).collect(Collectors.toList());

        // using stream
        long startTime = System.currentTimeMillis();
        List<Long> factorialsWithStream =  listnums.stream().map(PArallelStreamDemo::factorial).collect(Collectors.toList());
        // System.out.println("Factorials with sequencial stream : " + factorialsWithStream);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for Factorials with sequencial stream : " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        List<Long> factorialsWithParallelStream = listnums.parallelStream().map(PArallelStreamDemo::factorial).collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for Factorials with sequencial stream : " + (endTime - startTime) + "ms");


        // What can go wrong with parallel stream
        // Example : cumulitive Sum of [1, 2, 3, 4, 5, 6, 7]
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // int sum = 0;
        // nums.parallelStream().map(x -> {
        //     int i = x + sum; // not possible to use 'sum' inside the parallel stream as it can loose consistancy of data accross threads
        //     sum = i;
        //     return i; 
        // }).collect(Collectors.toList());
        AtomicInteger sum0 = new AtomicInteger(0);
        List<Integer> cumulitiveSum0 = nums.stream().map(x -> sum0.addAndGet(x)).collect(Collectors.toList());
        System.out.println("Cumulitive sum result with sequencial stream : " + cumulitiveSum0);

        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulitiveSum1 = nums.parallelStream().map(x -> sum.addAndGet(x)).collect(Collectors.toList());
        System.out.println("Cumulitive sum result with parallel stream : " + cumulitiveSum1);
    }

    private static long factorial(int num) {
        long result = 1;

        for (int i = 2; i <= num; i++)
        {
            result *= i;
        }

        return result;
    }
}
