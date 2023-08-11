import java.util.*;

class Solution {
    public int minimumSteps(int N, int[][] r) {
        // Build the adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : r) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            adjList.get(x).add(y);
        }

        // Calculate the in-degrees of all vertices
        int[] inDegree = new int[N + 1];
        for (int[] prerequisite : r) {
            int y = prerequisite[1];
            inDegree[y]++;
        }

        // Perform topological sorting using BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                N--;
                for (int next : adjList.get(curr)) {
                    if (--inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }

        return N == 0 ? steps : -1;
    }
    public static void main(String[] args) {
      int N = 3;
      int[][] r = {{1, 3}, {2, 3}};

      Solution solution = new Solution();
      int minimumSteps = solution.minimumSteps(N, r);
      System.out.println(minimumSteps);
}
}
