package Thread_test;


public class JavaThreadAnywhere {

    public static void main(String[] args) {
        // 获取当前线程
        Thread currentThread = Thread.currentThread();

        // 获取当前线程的线程名称
        String currentThreadName = currentThread.getName();

        System.out.printf("The main method was executed by thread:%s/n",
                currentThreadName);
        Thread helper = new Thread(new Helper());
        helper.start();
    }

    static class Helper implements Runnable {




        @Override
        public void run() {


            System.out.printf("The doSomething method was executed by thread:%s/n",
                    Thread.currentThread().getName());
        }
    }

}