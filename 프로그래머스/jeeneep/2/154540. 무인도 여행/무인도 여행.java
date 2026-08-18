import java.util.*;

class Solution {
    
    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        
        int R = maps.length;
        int C = maps[0].length();
        visited = new boolean[R][C];
            
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int count = bfs(maps, i, j);
                    result.add(count);
                }
            }
        }
        
        if (result.isEmpty()) result.add(-1);
        
        result.sort(null);
        return result.stream().mapToInt(i->i).toArray();
    }
    
    int bfs(String[] maps, int startR, int startC) {
        
        int R = maps.length;
        int C = maps[0].length();
        
        Queue<int[]> queue = new ArrayDeque<>();        
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        
        int sum = 0;
        while (!queue.isEmpty()) {
            
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            
            sum += (maps[curR].charAt(curC) - '0');
            
            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return sum;
    }
}