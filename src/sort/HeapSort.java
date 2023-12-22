package sort;

public class HeapSort {

    public void swap(int[] arr, int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /*
        arr:储存堆的数组
        n ： 数组的长度
        i： 待维护节点的下标
     */
    public void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            swap(arr,i,largest);
            heapify(arr,n,largest);
        }
    }

    public void heapSort(int[] arr, int n){

        //建堆
        for(int i = arr.length /2 - 1; i >= 0; i--){
            heapify(arr,n,i);
        }
        //排序
        for(int i = arr.length - 1; i > 0; i--){
            swap(arr,i,0);
            heapify(arr,i,0);
        }
    }
}
