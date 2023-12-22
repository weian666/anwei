package sort;

public class QuickSort {
    public int quickSort(int low, int high, int[] arr){
      int mid = arr[high];
      int pointer = low;
      for(int i = low; i < high; i++){
          if(arr[i] < mid){
              int temp = arr[i];
              arr[i] = arr[pointer];
              arr[pointer] = temp;
              pointer++;
          }
      }
      int temp = arr[pointer];
      arr[pointer] = mid;
      mid = temp;
      return pointer;
    }

    public void quick(int low, int high, int[] arr){
        if(low < high){
            int position = quickSort(low,high,arr);
            quick(low,position-1,arr);
            quick(position+1,high,arr);
        }
    }


}
