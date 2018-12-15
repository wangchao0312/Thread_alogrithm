package Sword;
import java.util.HashMap;
import java.util.Map;
public class Repteated_Num {
    /*public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers.length==0)
            return false;
        Map<Integer,Integer> map=new HashMap<>();
        int flag=0;
        for(int i=0;i<numbers.length;i++)
        {
            if(map.containsKey(numbers[i]))
            {
                duplication[0]=numbers[i];
                flag=1;
                break;

            }
            else
                map.put(numbers[i],1);
        }
        if(flag==1)
            return true;
        else
            return false;
    }*/
    public static boolean   duplicate1(int numbers[],int [] duplication) {
        if(numbers.length==0)
            return false;

        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i]<0||numbers[i]>numbers.length-1)
                return false;
        }
        for(int i=0;i<numbers.length;i++)
        {
            while(numbers[i]!=i)
            {
                if(numbers[i]==numbers[numbers[i]])
                {
                    duplication[0]=numbers[i];
                    return true;
                }
                int temp=numbers[numbers[i]];

                    numbers[numbers[i]]=numbers[i];
                    numbers[i]=temp;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] array={1,3,2,0, 2, 5, 3};
        int[] test=new int[1];
        System.out.println(duplicate1(array,test));
    }
}
