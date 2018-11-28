package Thread_test;

import java.util.concurrent.CountDownLatch;

/**
 CountDownLatch用法demo 不可复用
 
 */
public class countDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(2);
        new Thread(){
          @Override
          public void run(){
              System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
              try {
                  Thread.sleep(8000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
              latch.countDown();
          }


        }.start();

        new Thread(){
            @Override
            public void run(){
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                latch.countDown();
            }


        }.start();
        System.out.println("等待俩个线程执行完毕！！！");
        latch.await();
        System.out.println("继续执行主线程！！！");



    }
}
