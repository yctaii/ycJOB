package soutin;

import java.util.*;

/**
 * 完全多部图
 * 时间限制： 4000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一张包含N个点、M条边的无向图，每条边连接两个不同的点，且任意两点间最多只有一条边。对于这样的简单无向图，如果能将所有点划分成若干个集合，使得任意两个同一集合内的点之间没有边相连，任意两个不同集合内的点之间有边相连，则称该图为完全多部图。现在你需要判断给定的图是否为完全多部图。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行输入一个整数T表示数据组数，1≤T≤10。
 * <p>
 * 每组数据格式为：
 * <p>
 * 第一行包含两个整数N和M，1≤N≤1000，0≤M≤N(N-1)/2；
 * <p>
 * 接下来M行，每行包含两个整数X和Y，表示第X个点和第Y个点之间有一条边，1≤X，Y≤N。
 * <p>
 * 输出描述
 * 每组输出占一行，如果给定的图为完全多部图，输出Yes，否则输出No。
 */
public class JD1 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after the integer

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                graph.get(X).add(Y);
                graph.get(Y).add(X);
            }

            boolean isCompleteMultiGraph = true;
            boolean[] visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    if (!isBipartite(graph, i, visited)) {
                        isCompleteMultiGraph = false;
                        break;
                    }
                }
            }

            System.out.println(isCompleteMultiGraph ? "Yes" : "No");
        }
    }

    private static boolean isBipartite(List<List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] colors = new int[graph.size()];
        colors[start] = 1;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    colors[neighbor] = -colors[curr];
                    visited[neighbor] = true;
                } else if (colors[neighbor] == colors[curr]) {
                    return false;
                }
            }
        }

        return true;
    }





//    public static void main(String[] args) {
//        //赛码网，行数不确定时的输入写法
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
//        while (scanner.hasNextLine()) {
//            ArrayList<Integer> row = new ArrayList<Integer>();
//            String Line = scanner.nextLine();
//            if (Line.length() > 0) {
//                String[] arrLine = Line.split(" ");
//                for (int i = 0; i < arrLine.length; i++) {
//                    row.add(Integer.parseInt(arrLine[i]));
//                }
//                arr.add(row);
//            } else {
//                break;
//            }
//
//        }
//        Integer t = arr.get(0).get(0);
//        for(int i = 0; i < t; i++){
//            arr.get(i + 1 )
//        }
//
////            // 使用邻接矩阵表示图
////            boolean[][] graph = new boolean[n + 1][n + 1];
////
////            // 读取边信息并构建图
////
////            // 判断是否为完全多部图
////            boolean isCompleteMultipartite = checkCompleteMultipartite(graph, n);
////            System.out.println(isCompleteMultipartite ? "Yes" : "No");
//
//    }

}