package examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        // split the string with space and other special characters -> count
        String regex = "[ !,?._'@]+";
        List<String> listStr = Arrays.stream(s.split(regex)).collect(Collectors.toList());

        System.out.println(listStr.size() == 1 && listStr.isEmpty() ? 0 : listStr.size());
        listStr.forEach(System.out::println);

        // for (Map.Entry<String, Long> e : listStr.entrySet()) {

        // }
        scan.close();
    }
}
