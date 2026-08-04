import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int[] answer = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        List<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=1; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        /*
        1 - 3, 2
        2 - 3, 1, 4, 5
        3 - 6, 4, 2, 1
        4 - 3, 2
        5 - 2
        6 - 3
        */
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        answer[1] = 0;
         
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : graph[node]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    answer[next] = answer[node] + 1;
                }
            }
        }
        
        Arrays.sort(answer);
        int max = answer[n];
        int count = 0;
        for(int i = 1; i < n+1; i++){
            if(answer[i] == max){
                count++;
            }
        }
        
        return count;
    }
}