package start.string_handling;

import java.util.Arrays;

public class StringHandling {
    
    public static void main(String[] args) {
        String str1 = "I am studying ";
        String str2 = "in my room.";
        
        System.out.println("Length of Str1 = " + str1.length());

        String result = str1.concat(str2);
        System.out.println("Concatnation result = " + result);

        String fmt = String.format("My name is %s and I'm %d years old", "Kishor", 29);
        System.out.println("Formatted string = " + fmt);

        System.out.println("CharAt() = "+ str1.charAt(6));

        if (str1.equals(str2)) {    // compares the values
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are different");
        }

        System.out.println("indexOf('y') = " + str1.indexOf('y'));

        System.out.println("replace() = " + str1.replace('y', 'u'));

        String[] arr = str1.split(" ");
        Arrays.asList(arr).forEach(s -> System.out.println(s));

        String newStr = str1.substring(1, 8);
        System.out.println("Substring(1, 6) = "+ newStr);

        String intStr = String.valueOf(7);
        System.out.println(intStr);

        str1.chars().mapToObj(c -> (char)c).forEach(c -> System.out.println(c));
    }
}
