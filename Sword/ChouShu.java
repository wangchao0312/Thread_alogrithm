package Sword;
//丑数
import java.util.ArrayList;
public class ChouShu {
    public static int GetUglyNumber_Solution(int index) {
        ArrayList<Integer> array=new ArrayList<>();
        int flag=0;
        int T2=0,T3=0,T5=0;
        int M2,M3,M5;
        array.add(1);
        while(flag<=(index-1))
        {
            M2=array.get(T2)*2;
            M3=array.get(T3)*3;
            M5=array.get(T5)*5;
            if(M2<=M3)
            {
                if(M2<=M5)
                {
                    array.add(M2);
                    T2++;
                    flag++;
                }
                else
                {
                    array.add(M5);
                    T5++;
                    flag++;
                }
            }
            else
            {
                if(M3<=M5)
                {
                    array.add(M3);
                    T3++;
                    flag++;
                }
                else
                {
                    array.add(M5);
                    T5++;
                    flag++;
                }
            }
        }
        return array.get(array.size()-1);
    }


    public static void main(String[] args){
        System.out.println("*******************");
        System.out.println(GetUglyNumber_Solution(20));

    }
}
