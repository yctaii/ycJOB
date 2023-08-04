package soutin;

import java.util.Scanner;

public class huiwenchuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        //因为是换行输入，所以此时要用sc.nextLine()接收一下你的换行符即回车
        //然后在接收你的第二行输入，如果第二行还是数字  那就nextInt  如果是一个字符串  那就nextLine()
        sc.nextLine();  //接收换行符
        String str = "";
        if (sc.hasNextLine()) {
            str = sc.nextLine();
        }
        sc.close();

        System.out.println(len + " " + k + "\n" + str);
        if ("".equals(str)) return;
        if (str.length() != len) {
            System.out.println("输入参数有误");
        }

        StringBuilder res = concatStr(len, k, str);
        System.out.println(res);



    }

    private static StringBuilder concatStr(int len, int k, String str) {
        if (len <= 0 || k <= 0 || str.isEmpty()) {
            return null;
        }

        int begin = 0, end = begin + k;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbuilder = null;
        while (end <= str.length()) {
            sbuilder = new StringBuilder(str.substring(begin, end));
            if (judge(String.valueOf(sbuilder))) {
                sb.append(sbuilder);
            } else {
                sb.insert(0, sbuilder);
            }
            begin = end;
            end = begin + k;
        }

        return sb;

    }

    private static boolean judge(String tmp) {
        int i = 0, j = tmp.length() - 1;
        while (i < j) {
            if (tmp.charAt(i) != tmp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
