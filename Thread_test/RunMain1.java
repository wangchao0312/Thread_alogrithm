package Thread_test;


import java.util.Random;
import java.util.concurrent.*;

public class RunMain1 {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
            for (int i = 0; i < 10; i++) {
                completionService.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        int sleepValue = new Random().nextInt(5);
                        System.out.println("sleep = " + sleepValue + ", name: " + Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(sleepValue);
                        return "huhx: " + sleepValue + ", " + Thread.currentThread().getName();
                    }
                });
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(completionService.take().get());
            }
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}