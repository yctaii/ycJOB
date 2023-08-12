package java_basic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: Solution70
 * @author: Eric
 * @description: TODO
 * @date: 2023/8/12 13:09
 * @version: 1.0
 */
public class Solution70 {

    private Map<Integer, Integer> mapp = new HashMap<>();

    //1.自顶向上 从n 开始考虑
    // 递归
    public int fibonaci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        // 单纯递归会出现很多重复计算，为了防止重复计算
        // 用一个map将之前的结果记下来，
        // 后面如果用到 直接取，没有算过那就计算
        if (mapp.get(n) != null) {
            return mapp.get(n);
        } else {
            int ans = fibonaci(n - 1) + fibonaci(n - 2);
            mapp.put(n, ans);
            return ans;
        }
    }

    //2.自底向上，从0开始
    // 循环
    public int fibonaci_loop(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int pre = 0;
        int prepre = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = pre + prepre;
            pre = prepre;
            prepre = res;
        }
        return res;
    }


    @Test
    public void testRun() {
        System.out.println(fibonaci(36));
        System.out.println(fibonaci_loop(36));
    }
}
