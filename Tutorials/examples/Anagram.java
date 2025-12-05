package examples;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");

        
    }

    private static boolean isAnagram(String a, String b) {

        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }

        char[] aChar = a.toCharArray();
        sort(aChar);
        char[] bChar = b.toCharArray();
        sort(bChar);

        return equals(aChar, bChar);

        // return Arrays.equals(aChar, bChar);

    }

    // ==========================================
    static void sort(char[] ch) {

        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {

                if (ch[j] < ch[i]) {
                    // swap jth ele with ith ele
                    char tmp = ch[j];
                    ch[j] = ch[i];
                    ch[i] = tmp;
                }
            }
        }

    }

    static boolean equals(char[] arr1, char[] arr2) {
        // String.valueOf(arr1);
        return (String.valueOf(arr1).equals(String.valueOf(arr2)));
    }
}
