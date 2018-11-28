package Thread_test;

public class OrderPrintThread extends Thread{
    private Lock lock;
    private String flag;

    public OrderPrintThread(String flag, Lock lock) {
        this.flag = flag;
        this.lock = lock;
    }

    @Override
    public void run() {
        int count = 2;
        while(count > 0)
        {


            synchronized (lock) {
                if(lock.getFlag().equals(flag))
                {
                    System.out.print(flag);
                    count--;
                    if("A".equals(flag))
                        lock.setFlag("B");
                    else if("B".equals(flag))
                        lock.setFlag("C");
                    else if("C".equals(flag))
                        lock.setFlag("A");
                }
            }
        }
    }

    public static void main(String[] args) {
        Lock lock = new Lock();
        lock.setFlag("A");
        OrderPrintThread thread1 = new OrderPrintThread("A", lock);
        OrderPrintThread thread2 = new OrderPrintThread("B", lock);
        OrderPrintThread thread3 = new OrderPrintThread("C", lock);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Lock
{
    private String flag;

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }
}
