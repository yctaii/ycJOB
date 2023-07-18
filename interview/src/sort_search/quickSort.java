package sort_search;


import java.util.Arrays;
import java.util.Vector;

/**
 * 快排 单边循环洛姆托算法
 * 每次用j元素跟基准点元素比较，比基准点小，则交换
 * i为被交换的位置
 * 第一次基准点选取最后一个元素
 */
public class quickSort {
    public static void main(String[] args) {
        int arr[] = {5, 3, 7, 2, 9, 1, 8, 4};
        partition(arr, 0, arr.length - 1);
//        partition_lomuto(arr, 0, arr.length - 1)
//        partitionMiddle(arr , 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 单边循环，i作为要交换的下标
     * j作为比较的下标
     * */
    public static void partition_lomuto(int[] arr, int l, int r) {
        if (l > r) return;
        int pv = arr[r];        //基准总是定为右边界
        int i = l;
        for (int j = l; j < r; j++) {   //比较从左边界开始
            if (arr[j] < pv) {
                if (i != j) {
                    //若j位置元素比基准点小，则与i位置元素交换
                    swap(arr, i, j);
                }
                //i向后移
                i++;
            }
        }
        if (i <= r) {
            swap(arr, i, r);
        }
        System.out.println(Arrays.toString(arr) + "此次基准点元素：" + arr[i]);
        partition_lomuto(arr, l, i - 1);
        partition_lomuto(arr, i + 1, r);
    }

    /***
     * 双边循环，选取一个基准点
     * 然后分别从左边界和右边界开始
     * */
    public static void partition(int[] arr, int l, int r) {
        if (l >= r ) return;
        int i = l, j = r;
        int pV = arr[i];    //选左边则从右边开始找
        while( arr[j] > pV && j > i) j--;
        while (arr[i] <= pV && i < j) i++;
        swap(arr,i,j);
        partition(arr, l, i - 1);
        partition(arr, i + 1, r);
    }

    public static void partitionMiddle(int[] arr, int l, int r){
        if (l > r) return;
        int i = l, j = r, m;
        m = (i + j) >>> 1;
        while (i <= j && arr[i] < arr[m])  i++;
        while (i <= j && arr[j] > arr[m])  j--;
        swap(arr, i, j);
        partitionMiddle(arr, l, j - 1  );
        partitionMiddle(arr,   j+ 1, r);

    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

