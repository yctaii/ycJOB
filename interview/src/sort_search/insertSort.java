package sort_search;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 2, 6, 7, 9, 4};
        inserSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void inserSort(int[] arr) {
        //假设前i - 1 个位置是有序的，待插入为第i个元素
        //第一次假设索引0是有序，待插入为索引 ： 1 元素
        //第二次假设索引0 - 1 是有序，待插入为索引 ：2 元素
        //最后一个待插入元素为 arr.length - 1个元素
        for(int i = 1; i < arr.length; i++){
            int t = arr[i];     //待插入元素可能会被替换，先记录下来
            int j = i - 1;      //有序的最后一个元素的索引，从它开始向前比较
            while(j >= 0){
                if(t < arr[j]){
                    //如果待插入元素比前一个小，则向后移一位
                    arr[j + 1] = arr[j];
                }else{
                    //前面元素有序，当待插入元素比当前的大了
                    //那它比前面所有元素都大，所以不需要移动
                    break;
                }
                j--;   //前面所有元素都要比较
            }
            //当前的j是最后有序的前一位  j-- 所以j + 1 是待插入元素的位置
            arr[j + 1] = t;
        }
    }

}
