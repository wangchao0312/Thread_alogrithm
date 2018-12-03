package Thread_test;

public class Service {

    int i=1;
    public void testMethod() {
        try {
            synchronized (this) {
                i++;
                System.out.println(i);
                System.out.println("begin wait() ThreadName="
                        + Thread.currentThread().getName());
                wait();
                System.out.println("  end wait() ThreadName="
                        + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotifyMethod() {
        try {
            synchronized (this) {
                System.out.println("begin notify() ThreadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
                notifyAll();
                Thread.sleep(5000);
                System.out.println("  end notify() ThreadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Service service1=new Service();
        Service service2=new Service();
        Thread threadA=new Thread(){
          @Override
          public void run(){
              service1.testMethod();
              service1.synNotifyMethod();
          }

        };
        Thread threadB=new Thread(){
            @Override
            public void run(){
                service2.testMethod();
                service2.synNotifyMethod();
            }
        };
        threadA.start();
        threadB.start();

    }
}