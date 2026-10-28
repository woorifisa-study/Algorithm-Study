class Solution {
    
    static int count = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
    
        return count;
    }
    
    void dfs(int depth, int k, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                dfs(depth+1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        count = Math.max(count, depth);
    }
        
}