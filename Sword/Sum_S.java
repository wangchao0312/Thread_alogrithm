package Sword;
import java.util.ArrayList;
//
public class Sum_S {

        public  static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> finalresult=new ArrayList<>();
            ArrayList<Integer> inner=new ArrayList<>();
            for(int i=1;i<sum;i++)
            {
                int result=0;
                int j=i;
                while(result<sum)
                {
                    result+=j;
                    j++;
                }
                //core
                if(result==sum)
                {
                    ArrayList<Integer> temp=new ArrayList<>();
                    for(int count=i;count<=j-1;count++)
                        temp.add(count);
                    finalresult.add(temp);
                }
            }
            return finalresult;
        }

        public static void main(String[] args){
            System.out.println(FindContinuousSequence(3));
        }
}
