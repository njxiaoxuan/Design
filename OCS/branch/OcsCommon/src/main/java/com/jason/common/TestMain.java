package com.jason.common;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
           Thread  thread1=new TestThread1();
           Thread  thread2=new TestThread2();
           thread1.start();
           thread2.start();
           thread1.join();

    }
}
