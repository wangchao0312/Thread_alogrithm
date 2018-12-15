package Sword;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Puke {
    public static boolean isContinuous(int [] numbers) {
        if(numbers.length==0)
            return false;
        int j;
        //数组0的个数
        int sum_0=0;
        //数组需要0的个数
        int sum=0;
        for(int i=0;i<numbers.length;i++)
        {
            int temp=numbers[i];
            for( j=i;j>0&&temp<numbers[j-1];j--)
                numbers[j]=numbers[j-1];
            numbers[j]=temp;
        }
        //计算数组中有几个0
        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i]==0)
                sum_0++;
            else
                break;
        }
        //计算一共需要多少个0？
        for(int i=sum_0;i<numbers.length-1;i++)
        {
            if(numbers[i]==numbers[i+1])
                return false;
            sum=sum+numbers[i+1]-1-numbers[i];
        }
        if(sum_0>=sum)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
      /*  int[] array={1,0,3,4,5};
        System.out.println(isContinuous(array));*/
        List<Integer> list=new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }
}
