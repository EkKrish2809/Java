package practice.java;

public class StringTypes {
 
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = s1;
        s1 += "d"; // creates new object in string pool, hence different reference
        System.out.println(s1 + " " + s2 + " " + (s1 == s2));

        StringBuilder str1 = new StringBuilder("abc");
        StringBuilder str2 = str1;
        str1.append("d"); // points to same object in heap, hence same reference
        System.out.println(str1 + " " + str2 + " " + (str1 == str2));

        StringBuffer strBuf1 = new StringBuffer("abc");
        StringBuffer strBuf2 = strBuf1;
        strBuf1.append("d"); // points to same object in heap, hence same reference
        System.out.println(strBuf1 + " " + strBuf2 + " " + (strBuf1 == strBuf2));
    }

}
