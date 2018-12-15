package Sword;
import java.util.LinkedList;
import java.util.List;
public class Circle {
    public int LastRemaining_Solution(int n, int m) {
        if(n==0)
            return -1;
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<n;i++)
            list.add(i);
        int index=0;
        while(list.size()>1)
        {
            for(int j=1;j<m;j++)
                index=(index+1)%list.size();

            list.remove(index);
        }
        return list.get(0);
    }
}
