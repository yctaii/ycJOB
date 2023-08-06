package java_basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution4
 * @author: Eric
 * @description: TODO
 * @date: 2023/8/6 13:38
 * @version: 1.0
 */
public class Solution4 {

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    public static double findMedianSortedArrays(int[] n1, int[] n2) {
        // //复杂度o(n)
        // ArrayList<Integer> ar = new ArrayList<Integer>();
        // for(int nn : n1) ar.add(nn);
        // for(int mm : n2) ar.add(mm);
        // Collections.sort(ar);
        // int len = n1.length + n2.length;
        // if(len%2 == 0) return ((double)ar.get(len >> 1) + (double)ar.get((len >> 1) - 1))/2;
        // return (double)ar.get(len >> 1);



        int l1 = n1.length, l2 = n2.length, len = l1 + l2;
        int i = 0, j = 0, k = 0;
        int[] arr = new int[len];
        //开始放元素
        //之所以带等于号。是因为有一个放完后下标被加加后已经等于length了
        while(i <= l1 && l2 >= j){
            //考虑边界情况
            //当n1的元素放完，n2的元素直接放
            if(l1 == i){
                //这边不用等号，是因为如果等于length时方位数组直接越界了
                //当n1放完，n2直接放就行
                while(j < l2) arr[k++] = n2[j++];
                // 跳出 while后。n2也就放完了，则直接break大循环
                break;
            }else if(l2 == j){
                //n2放完，n1却没有放完
                while(i < l1) arr[k++] = n1[i++];
                break;
            }

            //若n1 n2都没放完则要比较大小再放
            arr[k++] = n1[i] <= n2[j] ? n1[i++] : n2[j++];
        }

        //整个arr数组是有序的,若总元素个数为偶数返回相加除2
        if(len % 2 == 0)    return ((double)arr[(len >>1) - 1] + (double)arr[len >> 1])/2;
        return (double)arr[len >> 1];

    }

}
