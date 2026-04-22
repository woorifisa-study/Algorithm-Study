import java.util.*;

class Solution {
    // 상하좌우 
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 방문 체크 배열
        boolean[][] visited = new boolean[n][m];
        
        // 큐 생성
        Queue<Node> queue = new LinkedList<>();
        // 시작점 큐에 넣기
        queue.add(new Node(0, 0, 1));
        // 방문 체크
        visited[0][0] = true;
                
        // While 루프 (큐가 빌 때까지)
        while (!queue.isEmpty()) {
            
            Node cur = queue.poll();
            
            if (cur.x == n-1 && cur.y == m-1) return cur.dist;
            else {
                // 상하좌우 탐색
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    
                    // 맵 범위 안이고, 벽이 아니고(1), 미방문이면
                    if ((nx >=0 && nx < n && ny >= 0 && ny < m) 
                        && maps[nx][ny] == 1 && visited[nx][ny] == false)  {
                        visited[nx][ny] = true;
                        
                        queue.add(new Node(nx, ny, cur.dist + 1));
                        
                    }                  
                    
                }                
                
            }
            
        }
        
        return -1;
    }
    
    static class Node {
    int x;
    int y;
    int dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
}