package paixu.alogrithm_wangchao;

public class insert_sort {
    /**
     * 插入排序。。。swap版本
     * @param arr
     */
    public static void insertionSort1(int[] arr){
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(arr[j]<arr[j-1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else
                    break;
            }
        }
    }

    /**
     * 插入排序改进版本
     * @param arr
     */
    public static void insertionSort2(int[] arr){
        for(int i=0;i<arr.length;i++)
        {
            int e=arr[i];
            int j;
            for(j=i;j>0&&arr[j-1]>e;j--)
                arr[j]=arr[j-1];
            arr[j]=e;
        }
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    public static void main(String[] args)
    {
        int[] array={10,9,8,7,6,5,4,3,2,1};
        insertionSort2(array);
        print(array);
    }

}
