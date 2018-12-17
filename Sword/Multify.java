package Sword;

public class Multify {
   /*暴力计算
    public int[] multiply(int[] A) {
        int[] B=new int[A.length];
        for(int i=0;i<A.length;i++)
        {
            int sum=1;
            for(int j=0;j<A.length;j++)
            {
                if(j!=i)
                    sum*=A[j];
            }
            B[i]=sum;
        }
        return B;
    }
    */
   public int[] multiply(int[] A) {
       int length=A.length;
       int[] result=new int[length];
       int[] first=new int[length];
       int temp=1;
       for(int i=0;i<length;i++)
        {
            temp*=A[i];
            first[i]=temp;
        }
        temp=1;
        for(int i=length-1;i>0;i--)
        {
            result[i]=first[i-1]*temp;
            temp*=A[i];
        }
        result[0]=temp;
        return result;
   }
}
