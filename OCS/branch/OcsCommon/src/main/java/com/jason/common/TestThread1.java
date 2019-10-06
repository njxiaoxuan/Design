package com.jason.common;

public class TestThread1 extends  Thread {

    @Override
    public void run() {
            for(int i=0;i<100;i++)
            {
                 TestThreadLocal.threadLocal.set("i="+i);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(TestThreadLocal.threadLocal.get());
            }
    }
}
