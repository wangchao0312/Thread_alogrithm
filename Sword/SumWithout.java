package Sword;

public class SumWithout {
    public static int Add(int num1,int num2) {
        int sum1;
        int sum2;
        int result;
        while(true)
        {
             sum1=num1^num2;
             sum2=num1&num2;
             if(sum2==0)
                 break;
             sum2=sum2<<1;
             if((sum1&sum2)==0)
                 return sum1+sum2;
             num1=sum1;
             num2=sum2;
        }
        if(sum2==0)
            return sum1+sum2;
        else
            return sum1+sum2;

    }
    public static void main(String[] args){
        System.out.println(Add(10,21));
    }
}
