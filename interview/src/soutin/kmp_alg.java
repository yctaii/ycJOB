package soutin;

/**
 * @projectName: ycJob
 * @package: soutin
 * @className: kmp_alg
 * @author: Eric
 * @description: TODO
 * @date: 2023/8/4 16:29
 * @version: 1.0
 */

import java.util.*;

public class kmp_alg {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String hay = sc.nextLine();
        sc.close();
        int[] lps = computeLPS(pattern);

        System.out.println(Arrays.toString(lps));

        searchPatter(pattern, hay);
        String a = sc.nextLine();


    }

    public static void searchPatter(String pat, String hay) {
        int[] lps = computeLPS(pat);
        int i = 0, j = 0;
        while (i < hay.length()) {
            if (hay.charAt(i) == pat.charAt(j)) {
                System.out.println(j);
                i++;
                j++;
            }

            if (j == pat.length()) {
                System.out.println("Found at: " + (i - j));
                return;
            } else if (i < hay.length() && hay.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                    System.out.println(j);
                } else {
                    i++;
                }
            }
        }
        System.out.println("Not found");
    }


    public static int[] computeLPS(String str) {
        int[] res = new int[str.length()];
        int len = 0, i = 1;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                res[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = res[len - 1];

                } else {
                    res[i] = 0;
                    i++;
                }
            }
        }
        return res;
    }
}
