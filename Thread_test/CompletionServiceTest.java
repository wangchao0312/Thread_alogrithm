package Thread_test;

import java.util.concurrent.*;
import java.util.concurrent.Executor;

public class CompletionServiceTest {
    private static ExecutorService executor = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletionService<Long> completionservice=new ExecutorCompletionService<Long>(executor);

        for(int i=1;i<=50;i++)
        {
            completionservice.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    return 1l;
                }
            });
        }
        long result=0l;

        for(int i=0;i<100;i++)
        {
            result+=completionservice.take().get();
            System.out.println(result);
        }

    }
}
