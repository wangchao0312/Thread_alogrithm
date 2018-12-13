package Sword;

public class Time {
    public int GetNumberOfK(int [] array , int k) {
        int firstplace=First(array,k,0,array.length-1);
        int lastplace=Last(array,k,0,array.length-1);
        if(firstplace!=-1&&lastplace!=-1)
        return lastplace+1-firstplace;
        return 0;
    }
    //找到数组array[start,end]中k第一次出现的位置。
    public int First(int[] array,int k,int start,int end){
        if(start>end)
            return -1;
        int midIndex=start+(end-start)/2;
        int MiddleValue=array[midIndex];
        if(MiddleValue==k)
        {
            if(midIndex==0||(midIndex>0&&array[midIndex-1]!=MiddleValue))
                return midIndex;
            else
                end=midIndex-1;
        }
        else if(MiddleValue>k)
            end=midIndex-1;
        else
            start=midIndex+1;

        return First(array,k,start,end);
    }
    //找到数组中k出现的最后一个位置
    public int Last(int[] array,int k,int start,int end){
        if(start>end)
            return -1;
        int midIndex=start+(end-start)/2;
        int MiddleValue=array[midIndex];
        if(MiddleValue==k)
        {
            if(midIndex==array.length-1||(midIndex<array.length-1&&array[midIndex+1]!=MiddleValue))
                return midIndex;
            else
                start=midIndex+1;
        }
        else if(MiddleValue>k)
            end=midIndex-1;
        else
            start=midIndex+1;

        return Last(array,k,start,end);
    }

}
