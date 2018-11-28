package paixu.alogrithm_wangchao;

public class quickSort{
    /*
    *
    *改进的算法，原来为选取第一个元素，现在为选取随机元素
    * */
    public static int partition(int[] arr,int l,int r){
        swap(arr,l,(int)(Math.random()*(r-l+1)+l));
        int v=arr[l];
        int j=l;
        for(int i=l+1;i<=r;i++)
        {
            if(arr[i]<v) {
             j++;
                swap(arr, i, j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    /**
     * 将相等的元素分布在数组俩侧，将不会导致n方的时间复杂度
     * @param arr
     * @param l
     * @param r
     */
    public static int partition2(int[] arr,int l,int r){
        swap(arr,l,(int)(Math.random()*(r-l+1)+l));
        int v=arr[l];
        int i=l+1,j=r;
        while(true){
            while(i<=r&&arr[i]<v)
                i++;
            while(j>=l+1&&arr[j]>v)
                j--;
            if(i>j)
                break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;

    }
    public static void quickSort(int[] arr,int l,int r)
    {
        if(l>=r)
            return;
        int p=partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args){
        int[] array={6,8,5,4,2,3,1};
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
        System.out.println("------------------");

        quickSort(array,0,array.length-1);

        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }

} 


