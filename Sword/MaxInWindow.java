package Sword;


import java.util.ArrayList;


public class MaxInWindow {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(size>num.length||size==0)
            return new ArrayList<Integer>();
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<=num.length-size;i++)
            list.add(max(num,i,size));

        return list;
    }
    public static void main(String[] args){

        int[] a={2,3,4,2,6,2,5,1};
        ArrayList<Integer> list;
        list=maxInWindows(a,3);
        for(Integer b:list)
            System.out.print(b+"  ");
    }
    public static int max(int[] num,int i,int size){
        int max=Integer.MIN_VALUE;
        for(int j=i;j<=i+size-1;j++)
        {
            if(max< num[j])
                max=num[j];
        }
        return max;
    }
}

