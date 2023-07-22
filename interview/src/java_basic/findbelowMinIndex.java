package java_basic;


import org.junit.Test;

public class findbelowMinIndex {

    //有序数组找到 = num 的最左位置
    //【1，2，3，4，4，4，5，6，7】
    //找 4 的最左位置  即 返回 3
    public int findMinindex(int[] arr, int target) {
        //有序数组用二分法
        //当中间的值大于等于 target 说明右边不会有等于target的值了直接 让 r = mid - 1
        //当中间小于 target  从右边开始找

        int L = 0, R = arr.length - 1;
        int ans = -1, mid;
        while (L <= R) {
            mid = (L + R) >>> 1;
            if (arr[mid] >= target) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }


    //现要求找到target所处的区间
    //找不到则返回应该插入的位置
    //其实找一个元素该插入的位置就是找他在有序数组的最左位置
    public int[] findTargetPos(int[] arr, int target) {
        int ans[] = {-1, -1};
        int l = 0, r = arr.length - 1;
        int m;
        //先找左边界 即当中点大于等于target 砍掉右边继续往左找
        while (l <= r) {
            m = (l + r) >>> 1;
            if (arr[m] >= target) {
                if (arr[m] == target)
                    ans[0] = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        //找右边界
        l = 0;
        r = arr.length - 1;
        while (l <= r) {
            m = (l + r) >>> 1;
            if (arr[m] <= target) {
                if (arr[m] == target)
                    ans[1] = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }


    @Test
    public void testRun() {
        int arr[] = {1, 2, 3, 4, 4, 4, 5, 7};

        System.out.println("目标出现最左位置" + findMinindex(arr, 6));
        int[] targetPos = findTargetPos(arr, 4);
        System.out.println("目标所在区间[" + targetPos[0] + "," + targetPos[1] + "]");
    }

}
