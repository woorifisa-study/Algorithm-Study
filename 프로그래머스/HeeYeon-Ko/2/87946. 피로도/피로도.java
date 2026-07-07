class Solution {
    
    static boolean[] visited;
    static int count = 0;
        
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return count;
       
    }
    
    // depth = 지금까지 몇 개의 던전을 탐험했는지
    public void dfs(int depth, int k, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true; // 방문
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false; // 방문 초기화 
            }
        }
        
        count = Math.max(count, depth);
    }
}