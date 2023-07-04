package sort_search;

import java.util.Arrays;

/**
 * SelectSort
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = { 1, 9, 6, 3, 5, 4, 7, 8, 2 };
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1 ; i++){
            int minIndex = i;
            for(int j = minIndex + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr , minIndex, i);
        }
    }

    private static void swap(int[] arr, int minIndex, int i) {
        int t = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = t;
    }
}