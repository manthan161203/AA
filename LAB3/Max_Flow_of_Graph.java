package LAB3;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Flow_of_Graph {

    static final int n = 6;

    public static boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < n; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    visited[v] = true;
                    parent[v] = u;
                }
            }
        }
        return false;
    }

    public static int fordFulkerson(int graph[][], int s, int t) {
        int rGraph[][] = new int[n][n];
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }
        int parent[] = new int[n];
        int maxFlow = 0;
        int pathFlow;

        while (bfs(rGraph, s, t, parent)) {
            pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        int graph[][] = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Max flow = " + fordFulkerson(graph, 0, 5));
    }
}
