import java.io.*;
import java.util.*;

public class Main {

    static int minimumClusterConnectionConst(int N, int M, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[N];
        int components = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }

        return components - 1;
    }

    static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        int[][] edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            String[] parts = br.readLine().trim().split(" ");
            edges[i][0] = Integer.parseInt(parts[0]);
            edges[i][1] = Integer.parseInt(parts[1]);
            edges[i][2] = Integer.parseInt(parts[2]); // weight (not used)
        }

        System.out.println(minimumClusterConnectionConst(N, M, edges));
    }
}
