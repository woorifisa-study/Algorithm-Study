import java.util.*;
class Solution {
    
    static int[][] board = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = {0, 1, 0, -1}; // 상우하좌
    static int[] dy = {-1, 0, 1, 0}; // 상우하좌
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        draw(rectangle);
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    int bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.add(new Node(characterX, characterY, 0));
        visited[characterX][characterY] = true;
        
        while(!queue.isEmpty()){
            
            Node cur = queue.poll();
            
            if(cur.x == itemX && cur.y == itemY){
                return cur.w / 2;
            }
            
            for(int i = 0; i < 4; i++){
           
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 1 || nx > 100 || ny < 1 || ny >100) continue;
                if(visited[nx][ny] || board[nx][ny] == 2 || board[nx][ny] == 0) continue;
                
                queue.add(new Node(nx, ny, cur.w + 1));
                visited[nx][ny] = true;
            
            }
        }
        
        return 0;
    }
    
    class Node { 
        int x, y, w; // w는 몇 칸 이동했는지 세는 용도
        
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    
    // 사각형의 내부는 2, 테두리는 1로 채우는 함수(2배)
    void draw(int[][] rectangle){
        for(int i = 0; i < rectangle.length; i++){
            
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int j = x1; j<=x2; j++){
                for(int k = y1; k<=y2; k++){
                    if(j == x1 || j == x2 || k == y1 || k == y2){
                        if(board[j][k] == 2) continue;
                        board[j][k] = 1;
                    }
                    else{
                        board[j][k] = 2;
                    }
                }
            }
        }
    }
}