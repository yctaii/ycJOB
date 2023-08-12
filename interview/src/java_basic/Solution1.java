package java_basic;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution1
 * @author: Eric
 * @description: TODO
 * @date: 2023/8/12 13:44
 * @version: 1.0
 */
public class Solution1 {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapp = new HashMap<>();
        //map 按照 值来存放下标
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            //首先定义一个数为nums[i] 那另一个数应该是 target - nums[i]
            int tmp = target - nums[i];
            Integer idx = mapp.get(tmp);
            //mapp中 key是数的值 value是数的下标
            //若能从mapp中 get到另一个数 即 get(key) 得到的是这个数的下标
            //说明这就是要找的第二个数，返回结果
            if(idx != null){
                //一开始肯定是找不到的
                //所以下标靠前的数肯定是从 mapp中 get到的
                ans[0] = idx;
                ans[1] = i;
            }else { //若是mapp中未找到，则说明mapp中尚未存放
                //那就把 nums[i]和它的下标 i存入map中
                mapp.put(nums[i],i);
            }
        }
        return ans;

    }

    @Test
    public void testRun(){
        int[] num = {1,2,4,6,9};
        int target = 6;
        int[] ints = twoSum(num, target);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(twoSum(num,2)));
    }
}
