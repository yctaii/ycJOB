package java_basic;

import org.junit.Test;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        //因为有序数组，所以插入排序
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) >>> 1;
            if(target == nums[m]){
                return m;
            }else if(nums[m] > target){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return l;
    }


    @Test
    public void Test() {
        int nums[] = {1, 3, 5, 6}, target = 2;
        System.out.println(searchInsert(nums, target));
    }
}