import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1){
                    graph[i + 1].add(j + 1);  
                }                 
            }
        }
        
        
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        
        return count;
    }
    
    private void dfs(int v){
        visited[v] = true;
        
        for(int next : graph[v]){
            if(!visited[next]){
                dfs(next);
            }
        } 
    }
}
