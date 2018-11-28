package paixu;


import java.util.*;

public class SelectionSort {

    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}



    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {




        String[] c = {"D", "C", "B", "A"};
        Arrays.sort(c);
        for( int i = 0 ; i < c.length ; i ++ ){
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
