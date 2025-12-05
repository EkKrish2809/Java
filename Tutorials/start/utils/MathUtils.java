package start.utils;

public class MathUtils {

    // public synchronized void getMultiples(int n) { // 1st way of Synchronization
    public void getMultiples(int n) {

        synchronized (this) {  // 2nd way of synchronization
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("=================================\n");
        }
    }
}
