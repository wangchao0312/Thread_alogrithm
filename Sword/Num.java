package Sword;

public class Num
{
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length==0||array.length<2)
            return ;
        int temp;
        temp=array[0];
        for(int i=1;i<array.length;i++)
            temp=array[i]^temp;

        int index=findFirst1(temp);
        for(int i=0;i<array.length;i++)
        {
            if(judge(array[i],index))
                num1[0]=num1[0]^array[i];
            else
                num2[0]^=array[i];

        }


    }
    public int findFirst1(int x){
        int index=0;
        while((x&1)==0&&index<32){
            x=x>>1;
            index++;
        }
        return index;
    }
    public boolean judge(int num,int index){
        num=num>>index;
        return (num&1)==1;
    }

}
