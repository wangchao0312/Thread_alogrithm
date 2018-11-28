package paixu.alogrithm_wangchao;

/**
 * 将快速排序分为三类进行排序~大于、小于、等于
 */
public class QuickSort3Ways {
    public static void QuiskSort3ways(int[] arr,int l,int r){
        if(r-l<=15)
        {
            insert_sort.insertionSort2(arr);
            return;
        }

        int lt=l;
        int gt=r+1;
        int i=l+1;
        swap(arr,l,(int)(Math.random()*(r-l+1)+l));
        int v=arr[l];
        while(i<gt)
        {
            if(arr[i]<v)
            {
                quickSort.swap(arr,i,lt+1);
                i++;
                lt++;
            }
            else if(arr[i]>v)
            {
                quickSort.swap(arr,i,gt-1);
                        gt--;
            }
            else
            {
                i++;
            }
        }
        swap(arr,l,lt);
        QuiskSort3ways(arr,l,lt-1);
        QuiskSort3ways(arr,gt,r);
    }
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args){
        int[] array={1,2,3,4,8,5,2,41,6,4,1,2,4,4,2,41,6,4,6,4,1,5,4,8,13,1,4,6};

        for(int a:array)
            System.out.println(a);
        QuiskSort3ways(array,0,array.length-1);
        System.out.println("-------------------------");
        for(int a:array)
            System.out.println(a);
    }
}
