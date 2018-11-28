package Binary_Search;

public class binarySearch2 {
    //在arr数组中找到target
    //找到target 返回对应索引值
    //没找到 返回-1
    //递归操作
    public static int find(Comparable[] arr,Comparable target,int l,int r){
        if(l>r)
            return -1;
        int mid=l+(r-l)/2;
        if(arr[mid].compareTo(target)==0)
            return mid;
        if(arr[mid].compareTo(target)<0)
            return find(arr,target,mid+1,r);
        else
            return find(arr,target,l,mid-1);

    }

}

