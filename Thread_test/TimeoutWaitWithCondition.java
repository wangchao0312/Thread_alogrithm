package Thread_test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TimeoutWaitWithCondition {
    private static final ReentrantLock lock= new ReentrantLock();
    private static final Condition condition =lock.newCondition();
    private static boolean ready=false;
    protected static final Random random=new Random();
    public static void main(String[] args){
        Thread t=new Thread(){
          @Override
          public void run(){
              while(true)
              {
                  lock.lock();
                  try{
                      ready=random.nextInt()<4?true:false;
                      if(ready)
                          condition.signal();
                  }finally {
                      lock.unlock();
                  }
              }
            }
        };

        t.setDaemon(true);
        t.start();
        waiter(1000);
    }
public static void waiter(final long timeOut){
        if(timeOut<0)
            throw new IllegalArgumentException();

        final Date deadline =new Date(System.currentTimeMillis()+timeOut);
        boolean continueWait=true;
        lock.lock();
        try{
            while(!ready)
            {
                System.out.println("still not ready!!  false");
                if(!continueWait)
                {
                    System.out.println("timeOut !!!");
                    return;
                }
                continueWait=condition.awaitUntil(deadline);
            }
            System.out.println("Success!!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
}

}
