import java.util.*;

public class ReorientConnections {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] connection : connections) {
            graph.putIfAbsent(connection[0], new ArrayList<>());
            graph.putIfAbsent(connection[1], new ArrayList<>());
            
            graph.get(connection[0]).add(new int[] { connection[1], 1 }); // Original edge
            graph.get(connection[1]).add(new int[] { connection[0], 0 }); // Reversed edge
        }
        
        return dfs(graph, 0, new boolean[n]);
    }
    
    private int dfs(Map<Integer, List<int[]>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int changeCount = 0;
        
        for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor[0]]) {
                changeCount += neighbor[1]; // 1 if the edge needs to be changed, 0 if not
                changeCount += dfs(graph, neighbor[0], visited);
            }
        }
        
        return changeCount;
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };
        
        ReorientConnections solution = new ReorientConnections();
        int minChanges = solution.minReorder(n, connections);
        System.out.println("Minimum number of changes: " + minChanges);
    }
}

