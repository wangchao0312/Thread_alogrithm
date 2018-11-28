package Heap;

/**
 * 索引堆排序    反向查找~~~~（没写 ）
 */
public class IndexMaxHeap<Item extends Comparable>{

    protected Item[] data;
    protected int[] indexes;
    protected int count;
    protected int capacity;

    public IndexMaxHeap(int capacity){
        data=(Item[])new Comparable[capacity];
        this.capacity=capacity;
        count=0;
        indexes=new int[capacity+1];
    }
    public void insert(int i,Item item){
        assert count+1<=capacity;
        assert i+1>=1&&i+1<=capacity;
        i+=1;
        data[i]=item;
        indexes[count+1]=i;
        count++;
        shiftUp(count);
    }
    private void shiftUp(int k){
        while(k>=1&&data[indexes[k/2]].compareTo(data[indexes[k]])<0)
        {
            swapIndexes(k,k/2);
            k/=2;
        }
    }

    public Item extractMax(){
        assert count>0;
        swapIndexes(1,count);
        count--;
        shiftDown(1);
        return data[indexes[1]];
    }

    public void shiftDown(int k){
        while(k*2<=count){
            int j=2*k;
            if(j+1<=count&&(data[indexes[j]].compareTo(data[indexes[j+1]]))<0)
                j++;
            if(data[indexes[k]].compareTo(data[indexes[j]])>0)
                break;
            swapIndexes(k,j);
            k=j;
        }
    }

    public int extractMaxIndex(){
        assert count>0;
        int ret =indexes[1]-1;
        swapIndexes(count,1);
        count--;
        shiftDown(1);
        return ret;
    }

    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }
    public void change(int i,Item newItem){
        i++;
        data[i]=newItem;
        for(int j=1;j<=count;j++)
        {
            if(indexes[j]==i)
            {
                shiftDown(j);
                shiftDown(j);
                return;
            }
        }

    }

}
