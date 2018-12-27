package Sword;
//2018/12/27
public class RobotCount {


    public int movingCount(int threshold, int rows, int cols)
    {
        int result=0;
        int[][] flag=new int[rows][cols];
        result=helper(flag,0,0,threshold);
        return  result;
    }
    public int helper(int[][] flag,int i,int j,int threshold)
    {
        if(i<0||i==flag.length||j<0||j==flag[0].length||!sum(i,j,threshold)||flag[i][j]==1)
            return 0;
        int sum=1;
        flag[i][j]=1;
        sum+=(helper(flag,i+1,j,threshold)+helper(flag,i-1,j,threshold)+helper(flag,i,j-1,threshold)+helper(flag,i,j+1,threshold));
        return sum;
    }

    public boolean sum(int a,int b,int threshold){
        int sum=0;
        while(a!=0)
        {
            sum=sum+(a%10);
            a/=10;
        }
        while(b!=0)
        {
            sum=sum+(b%10);
            b/=10;
        }
        return sum<=threshold;
    }

    public static void main(String[] args) {

    }

}
