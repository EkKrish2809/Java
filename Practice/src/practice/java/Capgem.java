package practice.java;

// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

public class Capgem {
    public static void main(String[] args) {
        
  
     // largest prime num from 1 to 10
        // List<Integer> nums = Arrays.asList(1, 2,3,4,5,6,7,8,9,10);
        
        
        // reverser string ab$c output cb$a 
        // reverser string abc$d output cb$a
        /*
            Algorithm :
            1. get the index of '$' so that we can put it back to the same place after reversing the string
                Also predict the new index of that character after reversal
            2. reverse the original string using StringBuilder() 
            3. remove the '$' from reversed string
            4. put it back on older position in reversed string
        */

        String str = "ab$c";
        String str2 = "abdefg$cd";
        String str3 = "abdessfg#kkcd";
        String str4 = "abdefg.ssssscxcd";
        System.out.println("Original String : \n" + str);
        String res = reverseString(str, '$');
        System.out.println("Reversed String (with same index of $): \n" + res);
        System.out.println("Original String : \n" + str2);
        String res2 = reverseString(str2, '$');
        System.out.println("Reversed String (with same index of $): \n" + res2);
        System.out.println("Original String : \n" + str3);
        String res3 = reverseString(str3, '#');
        System.out.println("Reversed String (with same index of $): \n" + res3);
        System.out.println("Original String : \n" + str4);
        String res4 = reverseString(str4, '.');
        System.out.println("Reversed String (with same index of $): \n" + res4);
        
        // String[] s ={"java","spring boot","microserce"};
        // List<String> sArr = Arrays.asList(s);
        // Collections.reverse(sArr);
        // System.out.println(sArr);
        
    }

    private static String reverseString(String str, char c) {
        int index = str.indexOf(c);
        int newIndex = (str.length() - 1) - (index);
        StringBuilder stBuilder = new StringBuilder(str);
        stBuilder.reverse();
        stBuilder.deleteCharAt(newIndex);
        stBuilder.insert(index, c);
        String res = stBuilder.toString();
        return res;
    }
}
