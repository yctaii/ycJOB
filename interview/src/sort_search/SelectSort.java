package sort_search;

import java.util.Arrays;

/**
 * SelectSort
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 3, 5, 4, 7, 8, 2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        //每次选择最小的元素，如当前轮数的索引位置的元素交换
        for (int i = 0; i < arr.length - 1; i++) {
            //第0轮，循环结束则索引 0 是最小的
            //第1轮，循环结束则索引 1 是最小的
            //最后只需要选择索引为 arr.length - 2 的元素 会整体有序
            int minIndex = i;
            for (int j = minIndex + 1; j < arr.length; j++) {  //最后一个元素也要比较
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, minIndex, i);
            System.out.println("第" + i + "轮选择！" + Arrays.toString(arr));
        }


    }

    private static void swap(int[] arr, int minIndex, int i) {
        int t = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = t;
    }
}