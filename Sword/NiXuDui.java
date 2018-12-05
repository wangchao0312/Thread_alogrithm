package Sword;

public class NiXuDui {
    public int InversePairs(int [] array) {

        long sum=0;
        for(int i=0;i<array.length;i++)
        {
            for(int j=i+1;j<array.length;j++)
            {
                if(array[i]>array[j])
                   sum++;
            }
        }
        return (int)(sum%1000000007);
    }
}
