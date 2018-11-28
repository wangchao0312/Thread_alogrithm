package paixu;

public class selection {
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++)
        {
            int IDmin=i;
            for(int j=i;j<arr.length;j++)
            {
                if(arr[j]<arr[IDmin])
                    IDmin=j;
            }
            swap(IDmin,i,arr);
        }
    }
    public static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    public static void main(String[] args){
        int[] array={10,9,8,7,6,5,4,3,2,1};
        selectionSort(array);
        print(array);
    }

}
