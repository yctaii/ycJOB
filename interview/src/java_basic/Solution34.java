package java_basic;

import org.junit.Test;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        int[] ret = {-1, -1};
        if (nums.length == 0) return ret;

        while (l <= r) {
            m = (l + r) >>> 1;
            if (nums[m] == target) {
                ret[0] = m;
                ret[1] = m;
                break;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int indexL = ret[0], indexR = ret[1];
        while (indexL > 0) {
            if (nums[--indexL] == target) {
                ret[0] = indexL;
                continue;
            } else {
                ret[0] = ++indexL;
                break;
            }
        }
        while (indexR < nums.length - 1) {
            if (nums.length == 1){
                return ret;
            }
            if (nums[++indexR] == target) {
                ret[1] = indexR;
                continue;
            } else {
                ret[1] = --indexR;
                break;
            }
        }
        return ret;
    }


    @Test
    public void Test() {
        int[] nums = {1};
        int target = 1;
        int[] ints = searchRange(nums, target);
        System.out.println(ints[0] + " " + ints[1]);
    }

}

