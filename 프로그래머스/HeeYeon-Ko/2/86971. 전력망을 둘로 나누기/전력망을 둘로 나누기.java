import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        // 리스트 초기화
        for(int i = 1; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 간선 입력
        for(int i=0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for(int i=0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            dfs(1);
            answer = Math.min(answer, Math.abs(count-(n-count)));
            
            // 초기화
            count = 0;
            Arrays.fill(visited, false);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    public void dfs(int n){
        visited[n] = true;
        count++;
        
        for(int next : graph[n]){
            if(!visited[next]){
                dfs(next); 
            }
        }
    }
}