package start.threads_demo;

import start.utils.MathUtils;

public class ThreadDemo {

    public static void main(String[] args) {
        MathUtils obj = new MathUtils();
    
        Thread1 t1 = new Thread1(obj);
        Thread t2 = new Thread(new Thread2(obj));
        
        t1.start();
        t2.start();
        
    }
}

/*
    Two threads running in parallel with different tasks/resources assigned is not an issue.
    But it can become an issue when two or more threads accessing/updating single resource.
    "Thread synchronozation" is important for this case.

    for eg. if two threads are accessing same bank account, one for depositing the money and another for withdrawing it.
    We can not gurantee who will see what balance in that account. Hence it becomes important that one threadd should do 
    one task first while other thread should wait for 1st task to be completed by 1st thread.
*/