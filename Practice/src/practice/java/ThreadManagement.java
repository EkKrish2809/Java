package practice.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadManagement {

    public static void main(String[] args) throws Exception {
        // 1. Define the ExecutorService (The Thread Pool)
        // This pool manages the worker threads that CompletableFuture will use.
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // ExecutorService executor = Executors.newCachedThreadPool(2);

        System.out.println("Main thread started on: " + Thread.currentThread().getName());

        // 2. Start the Asynchronous Task (Supply data)
        CompletableFuture<String> userDataFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("--- 1. Fetching data on: " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1); // Simulate network latency
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "User Profile: John Doe";
        }, executor); // <-- Explicitly using our defined executor

        // 3. Define the Callback (Process data)
        // This task will run only AFTER userDataFuture is complete, 
        // using one of the executor's threads.
        CompletableFuture<Void> finalFuture = userDataFuture.thenAcceptAsync(userData -> {
            System.out.println("--- 2. Processing data on: " + Thread.currentThread().getName());
            String processedData = userData.toUpperCase() + " | Processed.";
            System.out.println("Result: " + processedData);
        }, executor); // <-- Explicitly using our defined executor

        // 4. Non-Blocking Main Thread Activity
        System.out.println("Main thread is NOT blocked and continues working...");

        ///////////
        // Object lock = new Object();
        Future<String> future = executor.submit(() -> {
            // lock.wait(10000);
            Thread.sleep(10000);
            return "Just fun";
        });
        System.out.println("Main thread is now UNBLOCKED. Result: " + future.get());

        // 5. Block only at the end (to wait for the result)
        // In a real application, you might chain more async tasks instead of blocking.
        finalFuture.get(); 

        System.out.println("Main thread finished.");

        // Shutdown the executor gracefully
        executor.shutdown();
    }
}