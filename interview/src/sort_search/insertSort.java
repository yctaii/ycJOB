package sort_search;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 2, 6, 7, 9, 4 };
        inserSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void inserSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > t) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                j--;
            }
            arr[j + 1] = t;
            System.out.println(Arrays.toString(arr));
        }
    }
}
