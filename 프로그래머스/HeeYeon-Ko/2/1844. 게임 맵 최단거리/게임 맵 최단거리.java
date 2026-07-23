import java.util.*;
class Solution {
    
    static boolean[][] visited; // 방문 여부
    static int[][] dist; // 거리
    static int[] dx = {1, 0, -1, 0}; // 하, 우, 상, 좌
    static int[] dy = {0, 1, 0, -1}; // 하, 우, 상, 좌
    
    public int solution(int[][] maps) {
     
        int n = maps.length; // 행
        int m = maps[0].length; // 열
        visited = new boolean[n][m]; 
        dist = new int[n][m];
        
        Queue<Point> queue = new ArrayDeque<>();
        visited[0][0] = true; // (0, 0)을 방문했다고 표시
        dist[0][0] = 1; 
        queue.add(new Point(0, 0)); // 시작점 삽입
        
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.x == n-1 && cur.y == m-1){
                return dist[cur.x][cur.y];
            }

            for (int i = 0; i < 4; i++) { // 방향 탐색
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위 확인 및 조건 검증
                if (nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                } 
                if (visited[nx][ny] || maps[nx][ny] == 0){
                    continue;
                } 

                visited[nx][ny] = true; // 방문 표시
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.add(new Point(nx, ny)); // 큐에 삽입
            }
        }
        
        return -1;
    }
    
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}