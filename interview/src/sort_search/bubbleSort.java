package sort_search;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = { 1, 9, 6, 3, 5, 4, 7, 8, 2 };
        bubble(arr);
    }

    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = tmp;
    }

}
