package Sword;

import java.util.Arrays;

public class NiXuDui {
static  int sum=0;        //[l,r]内逆序对总个数

    public int InversePairs(int [] array) {

return 1;

    }
    //使用递归进行排序 将arr数组从l至r排好序。
    public static void sort(int[] arr,int l,int r){
        if(l>=r)
            return;
        int mid=l+(r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,mid,l,r);
    }
    //归并过程 [l,...mid] [mid+1,...r]
    public static void    merge(int[] arr,int mid,int l,int r){
        int i=l;
        int j=mid+1;
        int[] temp= Arrays.copyOfRange(arr,l,r+1);
        for(int k=l;k<=r;k++)
        {
            if(i>mid)
            {
                arr[k]=temp[j-l];
                j++;
            }
            else if(j>r)
            {
                arr[k]=temp[i-l];
                i++;
            }
            else if(temp[i-l]-(temp[j-l])<=0)
            {
                arr[k]=temp[i-l];
                i++;
            }
            else
            {
                sum=sum+mid-i+1;
                arr[k]=temp[j-l];
                j++;
            }
        }
    }
    public static void main(String[] args){
        int[] test={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};

        for(int i=0;i<test.length;i++)
            System.out.print(test[i]+" ");
        System.out.println();
        System.out.println("***************");

        sort(test,0,test.length-1);
        for(int i=0;i<test.length;i++)
            System.out.print(test[i]+" ");
        System.out.println();
        System.out.println(sum);

    }



    /*import java.util.Arrays;
public class Solution {
      int sum=0;        //[l,r]内逆序对总个数

    public int InversePairs(int [] array) {
sort(array,0,array.length-1);
return sum;

    }
    //使用递归进行排序 将arr数组从l至r排好序。
    public  void sort(int[] arr,int l,int r){
        if(l>=r)
            return;
        int mid=l+(r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,mid,l,r);
    }
    //归并过程 [l,...mid] [mid+1,...r]
    public  void    merge(int[] arr,int mid,int l,int r){
        int i=l;
        int j=mid+1;
        int[] temp= Arrays.copyOfRange(arr,l,r+1);
        for(int k=l;k<=r;k++)
        {
            if(i>mid)
            {
                arr[k]=temp[j-l];
                j++;
            }
            else if(j>r)
            {
                arr[k]=temp[i-l];
                i++;
            }
            else if(temp[i-l]-(temp[j-l])<=0)
            {
                arr[k]=temp[i-l];
                i++;
            }
            else
            {
                sum=(sum+mid-i+1)%1000000007;

                arr[k]=temp[j-l];
                j++;
            }
        }
    }
}*/
}