import java.util.*;
class Solution {
    static int[] dir_x = {-1, 0, 1, 0}; // 상우하좌
    static int[] dir_y = {0, 1, 0, -1};
    static int[][] dist; // 현재 거리
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        int w = maps.length;
        int h = maps[0].length;
        
        dist = new int[w][h];
        visited = new boolean[w][h];
        
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0));
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(cur.x == w-1 && cur.y == h-1){
                return dist[cur.x][cur.y];
            }
            
            for(int i = 0; i < 4; i++){
                int new_x = cur.x + dir_x[i];
                int new_y = cur.y + dir_y[i];
                
                if(new_x < 0 || new_x > w-1 || new_y < 0 || new_y > h-1) continue;
                if(visited[new_x][new_y] || maps[new_x][new_y] == 0) continue;
                
                queue.add(new Point(new_x, new_y));
                visited[new_x][new_y] = true;
                dist[new_x][new_y] = dist[cur.x][cur.y] + 1;
            }
        }
        return -1;
    }
    
    class Point {
        int x;
        int y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}