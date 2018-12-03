package Thread_test;

public class MyObject {

    private String userName = "b";
    private String passWord = "bb";

    synchronized public void methodA(String userName, String passWord) {
        this.userName = userName;
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){

        }
        this.passWord = passWord;
    }

     synchronized public void methodB() {
        System.out.println("userName" + userName + ": " + "passWord" + passWord);
    }
    public static void main(String[] args){
         MyObject myobject=new MyObject();

        Thread threadA=new Thread(){

            @Override
            public void run(){
                myobject.methodA("wangchao","123456");
            }

        };
        threadA.start();


        Thread threadB=new Thread(){

            @Override
            public void run(){
                myobject.methodB();
            }

        };
        threadB.start();
    }

}