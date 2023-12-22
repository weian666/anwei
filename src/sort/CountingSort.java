package sort;

public class CountingSort {
    public int[] getMaxMin(int[] arr){
        int maxValue = arr[0];
        int minValue = arr[1];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }else{
                minValue = arr[i];
            }
        }
        return new int[]{maxValue,minValue};
    }
    public int[] countSorting(int[] arr){
        if(arr.length < 2){
            return arr;
        }
        int[] res = getMaxMin(arr);
        int max = res[0];
        int min = res[1];
        int[] out = new int[arr.length];
        int[] count = new int[max - min + 1];
        for(int i = 0; i < arr.length; i++){
            count[arr[i] - min]++;
        }
        for(int i = 1; i < max - min + 1; i++){
            count[i] += count[i-1];
        }
        for(int i = arr.length-1;i >= 0; i--){
            out[count[arr[i] - min]-1] = arr[i];
            count[arr[i] - min]--;
        }
        return out;
    }
}
