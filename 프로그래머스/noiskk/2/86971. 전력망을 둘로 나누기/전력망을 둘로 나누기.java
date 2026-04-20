import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 생성
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        int result = 100;
        
        // 간선 하나씩 끊기
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            visited = new boolean[n + 1];
            
            int count = dfs(v1);
            int other = n - count;
            
            result = Math.min(result, Math.abs(count - other));
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return result;
    }
    
    private int dfs(int v){
        visited[v] = true;
        int count = 1;
        
        for(int next : graph[v]){
            if(!visited[next]){
                count += dfs(next);
            }
        }
        
        return count;
    }
}