package com.jason.common;

public class TestThread2 extends  Thread {
    @Override
    public void run() {
        for(int i=100;i<200;i++)
        {
            TestThreadLocal.threadLocal.set("j="+i);
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(TestThreadLocal.threadLocal.get());
        }
    }
}
