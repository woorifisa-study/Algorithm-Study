import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return bfs(graph, n, 1);
    }
    
    int bfs(List<List<Integer>> graph, int n, int start) {
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    queue.add(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
        
        int distMax = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > distMax) {
                distMax = dist[i];
                count = 1;
            }
            else if (dist[i] == distMax) count++;
        }
        
        return count;
    }
}