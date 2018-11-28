package Thread_test;

public class Theada extends Thread{
    private Count count=new Count();
    public Theada(Count con){
        this.count=con;
    }
    public void run(){
        count.add();
    }
}
