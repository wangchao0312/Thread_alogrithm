package Thread_test;

import java.util.concurrent.ThreadLocalRandom;

public class YieldRunnable implements Runnable{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "开始执行！");

        while(!Thread.currentThread().isInterrupted()) {
            for(int i = 1; i < 6; i++) {
                System.out.println(name + "执行了[" + i + "]次");
                //注意，yield是静态方法
                Thread.yield();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + "执行结束！");
    }

    public static void main(String[] args) {
        System.out.println("主线程开始执行！");
        YieldRunnable runnable = new YieldRunnable();
        Thread thread = new Thread(runnable, "线程1");

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        System.out.println("主线程执行结束！");
    }

}
