package examples;

public class Pelindrome {
    
    public static void main(String[] args) {
        String word = "Racecar";

        System.out.println(isPelindrome(word.toLowerCase()) ? "Yes it is a pelindrome" : "Not a pelindrome");
    }

    private static boolean isPelindrome(String s){
        StringBuilder str = new StringBuilder(s);
        System.out.println( str);
        System.out.println( str.reverse());
        if (str.toString().equals(str.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }
}
