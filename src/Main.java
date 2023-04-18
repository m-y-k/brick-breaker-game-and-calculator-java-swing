import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};

        for (int ele : sumOfDistancesInTree(n, edges)) {
            System.out.print(ele + " ");
        }
    }
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        // 1 2 3 3 3
        // 3 * 10 ^ 4 * 3 * 10 ^ 4 = 9 * 10^ 8
        // 0 - 1 2
        // 2 - 3 4 5
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }
        //

        int[] ans = new int[n];

        boolean[] path = new boolean[n];
        for (int i = 0; i < n; i++) { //ans[1]
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                cnt += dfs(graph, i, j, path);
                System.out.print(cnt + " ");
            }
            System.out.println();
            ans[i] = cnt - 1;
        }
        return ans;
    }
    static int dfs(List<Integer>[] graph , int src, int dest, boolean[] path) {
        if (src == dest) return 1;
        path[src] = true;
        for (int nbr : graph[src]) {
            if (!path[nbr]) {
                int ans = dfs(graph, nbr, dest, path);
                if (ans != 0) return ans + 1;
            }
        }
        path[src] = false;
        return 0;
    }
}