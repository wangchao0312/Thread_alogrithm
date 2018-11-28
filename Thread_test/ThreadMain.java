package Thread_test;

public class ThreadMain {
    public static void main(String[] args){
        Count count=new Count();
        for(int i=0;i<10;i++)
        {
            Theada thead=new Theada(count);
            thead.start();
        }
        try{Thread.sleep(1000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("The final num is "+count.num);
    }
}
