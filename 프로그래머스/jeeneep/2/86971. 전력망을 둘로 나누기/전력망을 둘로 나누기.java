import java.util.*;

class Solution {
    
    List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        int minDiff = n;
        boolean[] visited = new boolean[n + 1];
        for (int[] wire : wires) {
            
            Arrays.fill(visited, false);
            
            int v1 = wire[0];
            int v2 = wire[1];
            
            int count = dfs(v1, visited, v1, v2);
            int diff = Math.abs(2 * count - n);
            
            if (diff == 0) return 0;
            minDiff = Math.min(diff, minDiff);
        }
        
        return minDiff;
    }
    
    int dfs (int cur, boolean[] visited, int skipV1, int skipV2) {
        
        visited[cur] = true;
        int count = 1;
        
        for (int next : graph.get(cur)) {
            
            if (visited[next] || (cur == skipV1 && next == skipV2) || (cur == skipV2 && next == skipV1)) continue;
                        
            count += dfs(next, visited, skipV1, skipV2);
        }
        
        return count;
    }
}