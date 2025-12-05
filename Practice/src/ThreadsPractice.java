
/*
 * Extending the Thread class
 * */

import java.util.concurrent.*;

class MyThread1 extends Thread {
	
	public void run() {
		System.out.println("Thread 1 is running");
	}
}

class MyThread2 extends Thread {
	
	public void run() {
		System.out.println("Thread 2 is running");
	}
}

/*
 * Example of thread management using ExecutorService class 
 * */

class ExecutorServiceExample {
	public void manageThread() {
		// Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit Runnable tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Running task " + taskId +
                                   " in thread " + Thread.currentThread().getName());
            });
        }

        // Submit Callable task with result
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });

        try {
            System.out.println("Callable result: " + future.get()); // waits for result
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executor.shutdown();
 
	}
}

public class ThreadsPractice {

	public static void main(String[] args) {
		
		// MyThread1 t1 = new MyThread1();
//		MyThread2 t2 = new MyThread2();
//		
		// t1.start();
        // t1.stop();
        // t1.start();
//		t2.start();

		
		// ======= ExecuotrService example ====
		
		ExecutorServiceExample exeService = new ExecutorServiceExample();
		exeService.manageThread();
	}

}
