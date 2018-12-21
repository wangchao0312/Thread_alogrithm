package Thread_test;

import java.util.concurrent.*;

public class Rejected_test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5,5,0,TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(),new RejectedExecutionHandler() {

            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                // 打印并丢弃。
                System.out.println(r.toString()+" is discard");
            }
        });

        for(int i=0;i<Integer.MAX_VALUE;i++){
            MyTask task = new MyTask("Task-"+i);
            es.execute(task);
            Thread.sleep(10);
        }

        es.shutdown();    // 若无该方法，主线程不会结束。

    }
    public static class MyTask extends Thread{
        String str;
        public MyTask(String str){
            this.str=str;
        }
        @Override
        public void run(){
            System.out.println(Thread.currentThread()+" is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}