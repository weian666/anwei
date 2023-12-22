package sort;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class mergeSort {
    public static int[] mergeSort(int[] arr){
        if(arr.length < 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr,0,mid);
        //Arrays.copyOfRange(arr,0,mid)是左闭右开。
        int[] arr2 = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(arr1), mergeSort(arr2));
    }
    public static int[] merge(int[] arr_1, int[] arr_2) {
        int [] sorted_arr = new int[arr_1.length + arr_2.length];
        int index = 0, index1 = 0, index2 = 0;
        while(index1 < arr_1.length && index2 < arr_2.length){
            if(arr_1[index1] < arr_2[index2]){
                sorted_arr[index] = arr_1[index1];
                index1++;
            }else{
                sorted_arr[index] = arr_2[index2];
                index2++;
            }
            index++;
        }
        if(index1 < arr_1.length){
            while (index1 < arr_1.length){
                sorted_arr[index] = arr_1[index1];
                index1++;
                index++;
            }
        }else{
            while (index2 < arr_2.length){
                sorted_arr[index] = arr_2[index2];
                index2++;
                index++;
            }
        }
        return sorted_arr;
    }
}
