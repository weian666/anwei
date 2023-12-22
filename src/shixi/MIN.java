package shixi;

import java.util.ArrayList;
import java.util.Arrays;

public class MIN {
    public void min(){
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        Arrays.sort(arr,(o1,o2)->o2-o1);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            long sum1 = list1.stream().reduce(Integer::sum).orElse(0);
            long sum2 = list2.stream().reduce(Integer::sum).orElse(0);
            long sum3 = list3.stream().reduce(Integer::sum).orElse(0);
            if(sum1 <= sum2 && sum1 <= sum3){
                list1.add(arr[i]);
            }
            if(sum2 < sum3 && sum2 < sum1){
                list2.add(arr[i]);
            }
            if(sum3 < sum2 && sum3 < sum1){
                list3.add(arr[i]);
            }
        }
    }
}
