package java_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class failSafe_Fast {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> integerList = Arrays.asList(arr);
//        arrayListFail_Fast(arr);
//        copyOnWriteFail_Safe(arr);
        vectorFail_Safe(integerList);
    }


    private static void arrayListFail_Fast(List<Integer> arr) {

        ArrayList<Integer> integers = new ArrayList<>(arr);
//        integers.stream().forEach(num ->{
//            System.out.println(num);
//        });
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    private static void copyOnWriteFail_Safe(List<Integer> arr){

        CopyOnWriteArrayList<Integer> cow = new CopyOnWriteArrayList<>(arr);

        cow.stream().forEach(num->{
            System.out.println(num);
        });


    }

    private static void vectorFail_Safe(List<Integer> arr){
        Vector<Integer> vInt = new Vector<>(arr);
        vInt.stream().forEach(num->{
            System.out.println(num);
        });
    }
}
