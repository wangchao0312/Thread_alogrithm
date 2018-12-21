package Thread_test;


import java.util.concurrent.*;

public class RunMain2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<String>(executorService);
        service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
              //  TimeUnit.SECONDS.sleep(3);
                System.out.println("3 seconds pass.");
                return "3秒";
            }
        });
        Thread.sleep(2000);
        System.out.println(service.poll());
        executorService.shutdown();
    }
}