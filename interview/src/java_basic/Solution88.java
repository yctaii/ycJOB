package java_basic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution88
 * @author: Eric
 * @description: TODO
 * @date: 2023/8/12 15:57
 * @version: 1.0
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int len = m + n;
        int[] tmp = new int[len];
        int i = 0, j = 0, k = 0;
        while (i <= m && j <= n) {
            if (i == m) {
                while (j < n) tmp[k++] = nums2[j++];
                break;
            } else if (j == n) {
                while (i < m) tmp[k++] = nums1[i++];
                break;
            } else {
                tmp[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
            }
        }
        for (int x = 0; x < nums1.length; x++) {
            nums1[x] = tmp[x];
        }
    }


    @Test
    public void testRun() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
