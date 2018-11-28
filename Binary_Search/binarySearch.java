package Binary_Search;

public class binarySearch {
    //在arr数组中找到target
    //找到target 返回对应索引值
    //没找到 返回-1
    //循环操作
    public static int find(Comparable[] arr,Comparable target){
        int l=0;
        int r=arr.length-1;
        int mid;
        while(l<=r){
            mid=l+(r-l)/2;
            if(arr[mid].compareTo(target)==0)
                return mid;
            if(arr[mid].compareTo(target)<0)
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = i;

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for(int i = 0 ; i < 2*N ; i ++) {
            int v = binarySearch.find(arr, i);
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

        return;
    }

}
