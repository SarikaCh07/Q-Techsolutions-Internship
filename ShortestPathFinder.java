import java.util.*;

public class ShortestPathFinder {
    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length; 
        int[] dist = new int[n];
        boolean[] visited = new boolean[n]; 
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[start] = 0; 
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int uDist = node[1];
            if (visited[u]) continue;

            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) { 
                    int newDist = uDist + graph[u][v];
                    if (newDist < dist[v]) { 
                        dist[v] = newDist;
                        pq.add(new int[]{v, dist[v]});
                    }
                }
            }
        }
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Node " + i + " is unreachable.");
            } else {
                System.out.println("Distance to node " + i + ": " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes in the graph: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter the adjacency matrix (0 for no edge, positive values for edge weight):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the start node: ");
        int startNode = sc.nextInt();
        dijkstra(graph, startNode);

        sc.close(); 
    }
}
