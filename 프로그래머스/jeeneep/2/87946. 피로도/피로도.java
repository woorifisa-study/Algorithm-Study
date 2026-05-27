class Solution {
    
    static int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
           
        // 던전 방문 여부 체크
        boolean[] visited= new boolean[dungeons.length];
        
        dfs(0, k, dungeons, visited);

        return maxCount;
    }
    
    static void dfs(int count, int k, int[][] dungeons, boolean[] visited) {
        
        for (int i = 0; i < visited.length; i++) {
            // 방문하지 않았고, 최소 필요 피로도가 현재 피로도 보다 낮은 경우
            if (!visited[i] && (k >= dungeons[i][0])) {
                visited[i] = true;
                dfs(count + 1, k - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
        
        maxCount = Math.max(maxCount, count);  
    } 
}