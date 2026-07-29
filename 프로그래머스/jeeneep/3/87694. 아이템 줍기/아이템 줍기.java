import java.util.*;

class Solution {
    
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new int[101][101];
        visited = new boolean[101][101];
        
        draw(rectangle);
        
        return bfs(new Node(2 * characterX, 2 * characterY, 0), itemX, itemY);
    }
    
    public void draw(int[][] rectangle) {
        
        for (int i = 0; i < rectangle.length; i++) {
            
            int x1 = 2 * rectangle[i][0]; 
            int y1 = 2 * rectangle[i][1];      
            int x2 = 2 * rectangle[i][2];
            int y2 = 2 * rectangle[i][3];
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }    
        
        for (int i = 0; i < rectangle.length; i++) {
            
            int x1 = 2 * rectangle[i][0];
            int y1 = 2 * rectangle[i][1];            
            int x2 = 2 * rectangle[i][2];
            int y2 = 2 * rectangle[i][3];
            
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 0;
                }
            }
        }     
    }
    
    public int bfs(Node start, int itemX, int itemY) {
        
        Queue<Node> q = new ArrayDeque<>();
        
        visited[start.x][start.y] = true;
        q.offer(start);
        
        while (!q.isEmpty()) {
            
            Node cur = q.poll();
            
            if (cur.x == 2 * itemX && cur.y == 2 * itemY) return cur.w / 2;
            
            
            for (int i = 0; i < 4; i++) {
                
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (0 <= nx && nx < 101 && 0 <= ny && ny < 101) {
                        if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                            visited[nx][ny] = true;
                            q.offer(new Node(nx, ny, cur.w + 1));
                        } 
                    }
            }
        }
        
        return -1;
        
    }
    
    static class Node {
        
        int x;
        int y; 
        int w;
        
        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}