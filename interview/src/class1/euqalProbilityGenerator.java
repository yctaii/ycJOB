package class1;

import org.junit.Test;

/**
 * @projectName: ycJob
 * @package: java_basic
 * @className: euqalProbilityGenerator
 * @author: Eric
 * @description: TODO
 * @date: 2023/7/18 10:54
 * @version: 1.0
 */
public class euqalProbilityGenerator {
    /**
     * 给定一个等概率返回器，能够等概率返回 1-5
     * 要求在不该动原函数的情况下等概率返回 3-7
     */

    public int f() {
        return (int) (Math.random() * 5) + 1;
    }


    /***
     * 首先把提供的函数改造成 等概率 0、1构造器
     * 原来是等概率返回1-5，一共五个数  我们可以将f()函数返回结果分为三部分
     * 即当 f()返回 1、2时  g()返回 0  f()返回3时 g()让f()重新生成  f()返回 4、5时 g()返回 1
     * 原理 当发现 f 返回 3时重新生成，所以在g 中 f 用不可能为3
     * 那么 f 返回 3的概率就被均匀分给了其他数 原来 1 2 3 4 5概率 0.2 现在把0.2分给剩下四个数
     * 所以  在 g 中 f 产生 1 2 4 5的概率 就都是 0.25
     * 所以返回 0 1的概率都是 50%
     */
    public int g1() {
        int tmp;
        do {
            tmp = f();
        } while (tmp == 3);
        if (tmp <= 2) return 0;
        return 1;
    }

    /**
     * 接下来就是利用 0 1构造器，通过移位 产生二进制， 而获取任意范围构造器
     * 比如获取 0 - 7的构造器  需要三个二进制位  即调用三次 0 1 构造器分别右移
     * 现在是构造 3 - 7的构造器   最大值7 只需要三个 0 1构造器
     */
    public int g2(){
        return (g1() << 2) + (g1() << 1) + (g1() << 0);
    }


    /**
     * 现在要获取 3 - 7的构造器  ，则 g2()得到 <=2 时  让他们重新获取
     * 那么 0-2的概率就被平均分到 3 - 7
     * 所以就得到了 3 - 7的构造器
     */
    public int g(){
        int tmp;
        do {
            tmp = g2();
        }while (tmp <= 2);
        return tmp;
    }


    /**
     * 给定一个函数 只返回 0 1  但返回概率不等 且不知道
     * 设计出等概率返回 0 1的函数
     *
     */

    public int ff(){
        return Math.random() < 0.76 ? 0 : 1;
    }

    /**
     * 思路： 随机两次   返回 0 0 概率 p ^ 2和 返回 1 1 都重新获取 概率 (1-p)^2 均分给剩下结果
     * 得到 0 1 返回 1 得到 1 0 返回 0   概率都是p*(1-p)
     * 就已经得到 0 1等概率构造器  返回 0 和 返回 1 概率相投
     */

    public int gg(){
        int ans = 0;
        do {
            ans = ff();
        }while(ans == ff());  //只有第一次和第二次取到的值不一样才返回
        return ans;
    }

    @Test
    public void testRun() {
        int testTime = 10000000;
        int[] count = new int[2];



        for (int i = 0; i < testTime; i++) {
            int num = g1();
            count[num]++;
        }
        for (int j = 0; j < count.length; j++) {
            System.out.println(j + "这个数字出现的概率： " + (double) count[j] / (double) testTime);
        }

        System.out.println("=============");

        int[] counts = new int[8];
        for (int i = 0; i < testTime; i++) {
            int num = g2();
            counts[num]++;
        }
        for (int j = 0; j < counts.length; j++) {
            System.out.println(j + "这个数字出现的概率： " + (double) counts[j] / (double) testTime);
        }

        System.out.println("=============");

        int[] countss = new int[8];
        for (int i = 0; i < testTime; i++) {
            int num = g();
            countss[num]++;
        }
        for (int j = 0; j < countss.length; j++) {
            System.out.println(j + "这个数字出现的概率： " + (double) countss[j] / (double) testTime);
        }
    }

}
