package java_basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution448
 * @author: Eric
 * @description: TODO
 * @date: 2023/8/12 16:31
 * @version: 1.0
 */
public class Solution448 {
    public List<Integer> findDisapper(int[] nums){
        //不能借助新空间
        //所以只能在原数组上动数字
        //将nums[i]这个下标上的元素都加上n
        //那出现过的数字的下标对应的数字都应该大于n
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            //由于数在之前可能已经呗动过了
            int tmp = nums[i]%n;  //先把它还原回原来的数
            nums[tmp] += n;
        }
        List<Integer> ll = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(nums[i] <= n){
                ll.add(i);
            }
        }

        return ll;

    }

    @Test
    public void tR(){
        int[] nn = {4,3,2,7,8,2,3,1};
        findDisapper(nn).stream().forEach(System.out::println);
    }
}
