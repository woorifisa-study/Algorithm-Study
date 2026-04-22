import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        
        // 우 하 좌 상
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
    
        int n = maps.length; // row
        int m = maps[0].length; // col
        
        boolean[][] visited = new boolean[n][m];
    
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offerLast(new int[]{0, 0, 1}); // row, col, count
        
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if(x == n - 1 && y == m - 1){
                return dist;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offerLast(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return -1;
        
    }
}