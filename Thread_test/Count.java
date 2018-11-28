package Thread_test;

public class Count {
    public int num=0;
    public synchronized void add(){
        try{Thread.sleep(4000);}
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        num+=1;
        System.out.println(Thread.currentThread().getName()+"-"+num);
    }
}
