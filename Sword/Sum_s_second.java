package Sword;
import java.util.ArrayList;
public class Sum_s_second {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        ArrayList<Integer> finalresult=new ArrayList<>();
        long multisum=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++)
        {
            int result=0;
            int j=i+1;
            while(result<sum)
            {
                result=array[i]+array[j];
                if(result<sum)
                {
                    result-=array[j];
                    j++;
                }
                else
                    break;
            }
            if(result==sum)
            {
                if(array[i]*array[j]<multisum)
                {
                    multisum=array[i]*array[j];
                    finalresult.clear();
                    finalresult.add(array[i]);
                    finalresult.add(array[j]);
                }
            }
        }
        return finalresult;
    }
    public static void main(String[] args){
        ArrayList test=new ArrayList();
         int[] array={1,2,4,7,11,15};
        test=FindNumbersWithSum(array,15);
    }

}
