import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        
        // bfs 사용해야 함(최단 거리 문제)
        return bfs(maps, isVisited);
    }
    
    public int bfs(int[][] maps, boolean[][] isVisited) {
        Queue<int[]> q = new ArrayDeque<>(); // 큐로 같은 거리 탐색
        q.add(new int[]{0, 0, 1}); // 행, 열, 거리
        isVisited[0][0] = true;
        
        // 상하좌우 탐색
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll(); // 현재값
            int x= cur[0];
            int y=cur[1];
            int dist = cur[2];
            
            // 목적지도착(상대편 위치)
            if(x==maps.length-1 && y==maps[0].length-1)
                return dist;
            
            // 상하좌우 탐색
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //범위 밖이면
                if(nx<0 || nx>=maps.length ||
                  ny<0 || ny>=maps[0].length) continue;
                // 벽이면
                if(maps[nx][ny] ==0) continue;
                //방문 여부
                if(isVisited[nx][ny]) continue;
                //통과 시 방문 처리
                isVisited[nx][ny] = true;
                
                // 다음 위치 거리 추가
                q.add(new int[]{nx, ny, dist+1});
            }
        }
        
        return -1; // 도착못함
    }
}