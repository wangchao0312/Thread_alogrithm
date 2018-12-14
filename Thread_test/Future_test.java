package Thread_test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.lang.Runnable;

public class Future_test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //创建一个Callable，3秒后返回String类型
        Runnable myCallable1 = new Runnable() {
            @Override
            public void run()  {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("call1方法执行了");
            }
        };
        Runnable myCallable2 = new Runnable() {
            @Override
            public void run()  {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("call2方法执行了");
            }
        };
        Runnable myCallable3 = new Runnable() {
            @Override
            public void run()  {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("call3方法执行了");
            }
        };


        executor.execute(myCallable1);
        executor.execute(myCallable2);
        executor.execute(myCallable3);

        executor.shutdown();

    }
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
