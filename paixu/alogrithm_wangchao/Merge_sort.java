package paixu.alogrithm_wangchao;

import java.util.Arrays;

public class Merge_sort {
    public static void merge(int[] arr,int mid,int l,int r)
    {
        int[] array= Arrays.copyOfRange(arr,l,r+1);
        int i=l;int j=mid+1;
        for(int k=l;k<=r;k++)
        {
            if(i>mid)
            {
                arr[k]=array[j-l];j++;
            }
            else if(j>r)
            {
                arr[k]=array[i-l];i++;
            }
            else if(array[i-l]>array[j-l])
            {
                arr[k]=array[j-l];
                j++;
            }
            else
            {
                arr[k]=array[i-l];
                i++;
            }
        }
    }
    /**
     * 递归
     * @param arr
     */
    public static void mergeSort(int[] arr,int l,int r){
        /* if(r-l<=15)
        * 调用插入排序；数量小的时候可以用插入排序来做
        * */
        if(l>=r)
            return;
        int mid=(l+r)/2;

        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        /*改进的归并算法*/
        if(arr[mid]<arr[mid+1])
        merge(arr,mid,l,r);
}

    /**
     * 自底向上的归并算法
     * @param arr
     */
    public static void mergrSortBU(int[]arr)
    {


    }
    public static void main(String[] args){
        int[] array={10,9,8,7,6,5,4,3,2,1};
        for(int i=0;i<array.length;i++)
        System.out.println(array[i]);
        System.out.println("------------------");

        mergeSort(array,0,array.length-1);

        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }
}
