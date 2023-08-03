package class2;

import org.junit.Test;

/**
 * @projectName: ycJob
 * @package: class2
 * @className: BitMap
 * @author: richard
 * @description: TODO
 * @date: 2023/7/31 16:56
 * @version: 1.0
 */
public class BitMapRealize {

    public static class BitMap {
        private long[] bits;

        // 一个long为64位 0 1，可以表示0-63
        // 则两个 long 可以代表 0-127是否出现过
        // 比如最大数 63  则需要1个long来记录   也就是 (63 + 64) >> 6
        // 即 (max + 64) >> 6  =  max >> 6 + 1 = max / 64 + 1
        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        //首先要确定这个数要用第几个long来记录   即 num >> 6
        // bits[num >> 6] 来记录 num出现过
        // 那么 这个数 在 bits[num >> 6] 的第几位呢？   一个Long 只有 64位
        // 所以应该是 bits[num >> 6] 中的 第 num % 64 位 即为 1
        // 而 与运算速度快于 取模   所以 num % 64 可写为 num & 63  即 num二进制与 11111111 与
        // 即只保留num的低 8 位，   比如是在第 3 位   那就把这个 1L 右移 3 位  即 xxxxx...x100
        // 要把这个数记录到 bits[num >> 6]上 那就是 把它的第三位置为1   要始终置1  直接异或，有1就为1
        // 要用 1L  即 long类型的1  不加 L 系统默认 是 int 1  只有三十二位  而long 要 64位 则高32位无反应
        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }


        // 删除即使把 bit[num >> 6] 位中的 第 num & 63 置为 0
        // 不能把其他位置为0   那就用与   原来是什么还是什么
        // 那就要与的数 除了 (num & 63) 为 0 其他都为 1   那就把 1L 左移  然后取反
        // 如第三位00000100  取反  11111011
        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        // 看他是否存在  即看 bits[num>>6]的 num & 63 是否为 1
        // 即与一下那一位  原始是啥还是啥
        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

        public String toString() {
            String res = new String();
            for (Long bit : bits) {
               res = Long.toBinaryString(bit);
            }
            return res;
        }
    }


    @Test
    public void testRun() {
        int a = 16;
        BitMap bp = new BitMap(63);;
        bp.add(a);
        System.out.println(bp.contains(a));
        System.out.println(bp.toString());
    }

}
