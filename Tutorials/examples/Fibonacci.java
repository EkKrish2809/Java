package examples;

public class Fibonacci {
    public static void main(String[] args) {
        int initial = 0;
        int next = 1;
        System.out.println(initial);
        System.out.println(next);
        fibonacci(initial, next, 10);
    }

    private static void fibonacci(int first, int second, int num) {
        if (num >= 0) {
            int sum = first + second;
            System.out.println(sum);
            fibonacci(second, sum, num - 1);
        }
    }
}
