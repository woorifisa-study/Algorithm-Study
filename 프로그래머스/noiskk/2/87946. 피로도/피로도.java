import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visited;
    static int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        
        dfs(0, k);
        
        return answer;
    }
    
    
    void dfs(int count, int energy){
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && energy >= dungeons[i][0]){
                visited[i] = true;
                energy -= dungeons[i][1];
                count += 1;
                
                if(count > answer) answer = count;
                dfs(count, energy);
                
                energy += dungeons[i][1];
                count -= 1;
                visited[i] = false;
            }
        }
    }
}