package class2;

/**
 * @projectName: ycJob
 * @package: soutin
 * @className: bitRealize
 * @author: Eric
 * @description: 用位运算实现加减乘除
 * @date: 2023/8/5 11:08
 * @version: 1.0
 */

class SoluBitOperater {

    //位运算的加法是
    // 首先  两个数的二进制数 异或  得到的是无进位和
    // 两个数 二进制与 再左移一位 得到的就是这一次的异或应该有的进位
    // 接下来就将 无进位和 和 异或的到的进位作为两个相加的数
    // 接下来就将 异或和 和 进位一直 异或 和与后左移  知道没有进位了
    // 相加结束  得出结果
    public int add(int a, int b) {
        int sum = 0;
        //当仍然有进位时
        while (b != 0) {
            // 异或  得到的是  无进位的两数只和
            sum = a ^ b;
            // 两数 与 再左移 1 位  得到上次该有的进位信息
            b = (a & b) << 1;
            // 把 a 置位 无进位和
            a = sum;
        }
        return sum;
    }

    //取一个数的相反数 即取反加一   因为 -128 ～ 127  3 取反是 -4  加一  -3
    public int negInt(int b) {
        return add(~b, 1);
    }

    //实现减法  可以改为加上它的相反数
    public int minus(int a, int b) {
        return add(a, negInt(b));
    }

    public int multi(int a, int b){
        int res = 0;
        while(b != 0){
            if((b & 1) != 0){
                // 被乘数最低位为 1
                // 就加上乘数
                res = add(res,a);
            }
            //被乘数最低位为0 就啥也不干， 但是乘数得左移，被乘数的右移
            //乘完以后 为支持 乘数带符号向右移一位
            a <<= 1;
            // 被乘数已经被乘掉了一位 左移一位
            b >>>= 1;
        }
        return res;
    }

    public int div(int a, int  b){
        //如果除法的两个数是负数，则转换成正数
        int x = isNeg(a) ? negInt(a) : a;
        int y = isNeg(b) ? negInt(b) : b;
        int res = 0;
        // x / y 为什么移31次因为 int是32位01，但最高位是负号为
        for (int i = 30; i >= 0; i = minus(i,1)) {
            //为什么用 x右移来判断 x还够不够减 而不是用 y左移
            //因为y左移如果过多可能会把原来负号为改变，从而变为负数
            if((x >> i) >= y){
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        // 由于除得时候都用绝对值，就要考虑正负
        // 如果两个数有一个为负数，则添加负号  ^是异或，只有出现一个false 一个true 才会返回true
        // 当 true ^ true时因为相同 所以异或下来结果时false
        // 所以只有一正一负的情况下才会给结果加负号
        return isNeg(a) ^ isNeg(b) ? negInt(res) : res;
    }



    public boolean isNeg(int a) {
        return a < 0 ? true : false;
    }

}

public class bitRealize {


    public static void main(String[] args) {
        SoluBitOperater sop = new SoluBitOperater();
        System.out.println(sop.add(62, -3));
        System.out.println(sop.minus(62, -3));
        System.out.println(sop.multi(65, -3));
        System.out.println(sop.div(63,-3));
        System.out.println(sop.div(-63,-3));
        System.out.println(sop.isNeg(-63) ^ sop.isNeg(-3));
    }


}
