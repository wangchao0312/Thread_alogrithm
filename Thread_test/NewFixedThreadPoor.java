package Thread_test;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Java线程：线程池
 *
 * @author 冯小卫
 */
public class NewFixedThreadPoor {
    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建线程
        Thread t1 = new MyThread();t1.setName("11");
        Thread t2 = new MyThread();t2.setName("22");
        Thread t3 = new MyThread();t3.setName("33");
        Thread t4 = new MyThread();t4.setName("44");
        Thread t5 = new MyThread();t5.setName("55");
        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        // 关闭线程池
        pool.shutdown();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}