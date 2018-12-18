package Thread_test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadMonitorDemo {
    volatile boolean inited=false;
    static int threadindex=0;
    final BlockingQueue<String> channel=new ArrayBlockingQueue<>(100);

    public static void main(String[] args) throws InterruptedException {
        ThreadMonitorDemo demo=new ThreadMonitorDemo();
        for(int i=0;i<100;i++)
            demo.service("test-"+i);
        Thread.sleep(1000);
        demo.init();


    }


    public synchronized void init()  {
        if(inited)
            return;
        System.out.println("init.....");
        WorkerThread workerthread=new WorkerThread();
        workerthread.setName("worker-"+threadindex++);
        workerthread.setUncaughtExceptionHandler(new ThreadMointor());
        workerthread.start();
        inited=true;
    }
    public void service(String msg) throws InterruptedException{
        channel.put(msg);
    }
    private class ThreadMointor implements Thread.UncaughtExceptionHandler{
        @Override
        public void uncaughtException(Thread t,Throwable e){
            System.out.println("Current Thread is "+Thread.currentThread()+" it is alive? "+t.isAlive());
            inited=false;
            init();

        }
    }
    private class WorkerThread extends Thread{
        @Override
        public void run(){
            System.out.println("Do something importport!!");
            String msg;
            while(true)
            {
                try {
                    msg=channel.take();
                    process(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void process(String msg){
        System.out.println("massage is "+msg);
        if((int)(Math.random()*10)<2)
            throw new RuntimeException("test");
    }
}
