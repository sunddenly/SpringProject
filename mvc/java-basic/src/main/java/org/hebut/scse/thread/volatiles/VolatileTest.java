package org.hebut.scse.thread.volatiles;

public class VolatileTest {
    static class MyObject {
        static volatile int mycount = 0;
    }
    public static void inc() {
        MyObject.mycount++;
    }
    public static void main(String[] args) {
        //同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    inc();
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + MyObject.mycount);
    }
}