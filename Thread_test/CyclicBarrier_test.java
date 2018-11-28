package Thread_test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * CyclicBarrier test
 */
public class CyclicBarrier_test {
    public static void main(String[] args) throws InterruptedException {
        final int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });
        for(int i=0;i<N;i++){
            if(i<=2)
            new Writer(barrier).start();
            else
            {
                Thread.sleep(5000);
                new Writer(barrier).start();
            }
        }
    }
        static class Writer extends Thread{
            private CyclicBarrier cyclicbarrier;
            public Writer(CyclicBarrier cyl){
                this.cyclicbarrier=cyl;
            }
            @Override
            public void run(){
                System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");

                try {
                    cyclicbarrier.await(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                System.out.println("所有线程写入完毕，继续处理其他任务...");
            }
        }





}
