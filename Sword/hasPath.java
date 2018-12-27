package Sword;

public class hasPath {
    public  static boolean haspath(char[] matrix, int rows, int cols, char[] str) {
        if(str.length>matrix.length)
            return false;
        int[][] flag=new int[rows][cols];
        char[][] array = new char[rows][cols];
        int ii=0,jj=0;
        for (int i = 0; i < matrix.length; i++)
        {
            array[ii][jj]=matrix[i];
            jj++;
            if(jj==cols)
            {
                ii++;
                jj=0;
            }
        }
        boolean result=false;
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[0].length ; j++) {
//                if(i==4&&j==7)
//                    System.out.println(123);;
//                flag=new int[rows][cols];
                result=helper(array,str,i,j,flag,0);
                if(result==true)
                    return true;
            }
        }
        return false;
    }
    public  static boolean helper(char[][] array,char[] str,int i,int j,int[][] flag,int index){
        if(i<0||i==array.length||j<0||j==array[0].length||flag[i][j]==1||str[index]!=array[i][j])
            return false;


            if(index==str.length-1)
                return true;
            flag[i][j]=1;
            if( helper(array,str,i-1,j,flag,index+1)||helper(array,str,i,j-1,flag,index+1)||helper(array,str,i+1,j,flag,index+1)||helper(array,str,i,j+1,flag,index+1))
                return true;
//            flag[i][j]=0;
            return false;
    }


    public static void main(String[] args) {

//        char[] test={'a','b','c','e','s','f','c','s','a','d','e','e'};
//         char[] str={'b','f','c','e'};
        char[] test;
        char[] str;
        String test1="ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        String test2="SGGFIECVAASABCEHJIGQEM";
        test=test1.toCharArray();
        str=test2.toCharArray();
      System.out.println(haspath(test,5,8,str));
    }
}
//链接：https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc
//        来源：牛客网
//
//        分析：回溯算法
//        这是一个可以用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的
//        第i个位置。如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
//        重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
//        　　由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个
//        字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
//        　　由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。 当矩阵中坐标为（row,col）的
//        格子和路径字符串中相应的字符一样时，从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下一个字符
//        如果4个相邻的格子都没有匹配字符串中下一个的字符，表明当前路径字符串中字符在矩阵中的定位不正确，我们需要回到前一个，然后重新定位。
//        　　一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
