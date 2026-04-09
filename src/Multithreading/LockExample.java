package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {

    }
    Lock lock = new ReentrantLock();

    public void outerMethod() {
        innerMethod();
        lock.lock();
    }

    public void innerMethod() {

        try{
            lock.lock();
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            lock.unlock();
        }

    }
}
