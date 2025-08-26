import java.util.*;

public class Another {

    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n+; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[px] > rank[py]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    public static int minimumClusterConnectionCost(int N, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2])); // Sort by weight
        DSU dsu = new DSU(N);
        int totalCost = 0;
        int connectedEdges = 0;

        for (int[] e : edges) {
            if (dsu.union(e[0], e[1])) {
                totalCost += e[2];
                connectedEdges++;
                if (connectedEdges == N - 1) break;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        System.out.println(minimumClusterConnectionCost(N, edges));
        sc.close();
    }
}