package Heap;

import java.util.*;

public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity ;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity){
        data = (Item[])new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    // 返回堆中的元素个数
    public int size(){
        return count;
    }

    protected Item ExtractMax(){
        assert count>0;
        Item item=data[1];
        swap(count,1);
        count--;
        SHiftDown(1);
        return item;
    }
    private void SHiftDown(int k){
        while(count>=2*k)
        {
            int j=2*k;
            if(j+1<=count&&data[j+1].compareTo(data[j])>0)
                j++;

            if(data[j].compareTo(data[k])>0)
                swap(k,j);
            else
                break;
            k=j;
        }

    }
    public void insert(Item item){
        assert capacity>=count+1;
        data[count+1]=item;
        count++;
        ShiftUp(count);
    }
    private void ShiftUp(int k){
        while(k>1)
        {
            if(data[k].compareTo(data[k/2])>0)
                swap(k,k/2);
            k/=2;
        }
    }

    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( ((int)(Math.random() * M)) );
        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.ExtractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];    }
}