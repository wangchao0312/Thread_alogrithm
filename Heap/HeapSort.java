package Heap;

/**
 * 原地堆排序~~~
 */
public class HeapSort {

    public static void sort(int[] arr){
        int n=arr.length;
        for(int i=(n-1)/2;i>=0;i--)
            Shiftdown(arr,n,i);
        for(int i=n-1;i>0;i--)
        {
            swap(arr,0,i);
            Shiftdown(arr,i,0);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    private static void Shiftdown(int[] arr,int n,int k){
        while(n>2*k+1)
        {
            int j=2*k+1;
            if(j+1<=n-1&&arr[j+1]>arr[j])
                j++;

            if(arr[j]>arr[k])
                swap(arr,k,j);
            else
                break;
            k=j;
        }

    }

}
