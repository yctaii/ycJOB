package java_basic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution283
 * @author: Eric
 * @description: TODO
 * @date: 2023/8/12 16:04
 * @version: 1.0
 */
public class Solution283 {

    public void moveZero(int[] nums){
        //冒泡，时间复杂度太高
//        for(int i = 0; i < nums.length; i++){
//            boolean flag = false;
//            for (int j = 0; j < nums.length - i - 1; j++) {
//                if(nums[j] == 0 && nums[j + 1] != 0){
//                    swap(nums,j,j+1);
//                    flag = true;
//                }
//            }
//            if(!flag){
//                return;
//            }
//        }
        //可以先扫描一下数组，把非0的数全放到左边，从下标0开始
        //同时还知道了0的个数，那就把数组后面位置全部置0
        int j = 0;  //用来记录非0元素最后的下标位置
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) nums[j++] = nums[i];
        }
        // 遍历完一遍后 j 就应该是 置0开始的位置
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private void swap(int[] nums, int j, int i) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    @Test
    public void tesR(){
        int[] nn = {0,1,0,2,3,0,4};
        moveZero(nn);
        System.out.println(Arrays.toString(nn));
    }
}
