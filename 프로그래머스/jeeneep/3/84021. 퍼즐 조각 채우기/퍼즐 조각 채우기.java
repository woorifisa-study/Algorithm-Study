import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        List<List<Point>> board_Coord = new ArrayList<>();
        List<List<Point>> table_Coord = new ArrayList<>();
        
        int len = game_board.length;
        boolean[][] board_visited = new boolean[len][len];
        boolean[][] table_visited = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (game_board[i][j] == 0 && !board_visited[i][j]) {
                    board_Coord.add(collectCoord(game_board, board_visited, new Point(i, j), 0));
                }
                if (table[i][j] == 1 && !table_visited[i][j]) {
                    table_Coord.add(collectCoord(table, table_visited, new Point(i, j), 1));
                }
            }
        }
        
        int answer = 0;
        boolean[] usedTable = new boolean[table_Coord.size()];

        for (int i = 0; i < board_Coord.size(); i++) {
            List<Point> boardPiece = board_Coord.get(i);

            for (int j = 0; j < table_Coord.size(); j++) {
                if (usedTable[j]) continue;

                List<Point> tablePiece = table_Coord.get(j);
                if (boardPiece.size() != tablePiece.size()) continue; 

                boolean isMatched = false;
                
                List<Point> targetPiece = tablePiece;

                for (int r = 0; r < 4; r++) {
                    boolean match = true;
                    for (int k = 0; k < boardPiece.size(); k++) {
                        Point b = boardPiece.get(k);
                        Point t = targetPiece.get(k);
                        
                        if (b.r != t.r || b.c != t.c) {
                            match = false;
                            break;
                        }
                    }

                    if (match) {
                        isMatched = true;
                        break;
                    }

                    targetPiece = rotate(targetPiece);
                }

                if (isMatched) {
                    answer += boardPiece.size();
                    usedTable[j] = true; 
                    break; 
                }
            }
        }
        
        return answer;
    }
    
    public List<Point> normalize(List<Point> list) {
        int minR = list.get(0).r;
        int minC = list.get(0).c;
        
        for (Point p : list) {
            if (p.r < minR) minR = p.r;
            if (p.c < minC) minC = p.c;
        }
        
        List<Point> normalized = new ArrayList<>();
        for (Point p : list) {
            normalized.add(new Point(p.r - minR, p.c - minC));
        }
        
        Collections.sort(normalized);
        return normalized;
    }
    
    public List<Point> rotate(List<Point> list) {
        List<Point> rotated = new ArrayList<>();
        for (Point p : list) {
            rotated.add(new Point(p.c, -p.r));
        }
        return normalize(rotated);
    }
    
    public List<Point> collectCoord(int[][] space, boolean[][] visited, Point start, int find) {
        Queue<Point> q = new ArrayDeque<>();
        List<Point> list = new ArrayList<>();
        
        q.offer(start);
        list.add(start);
        visited[start.r][start.c] = true;
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int r = cur.r + dx[i];
                int c = cur.c + dy[i];
                
                int len = space.length;
                if (0 <= r && r < len && 0 <= c && c < len) {
                    if (space[r][c] == find && !visited[r][c]) {
                        visited[r][c] = true;
                        Point p = new Point(r, c);
                        list.add(p);
                        q.offer(p);
                    }
                }
            }
        }
        
        return normalize(list); 
    }
    

    class Point implements Comparable<Point> {
        int r, c;
        
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        @Override
        public int compareTo(Point o) {
            if (this.r != o.r) {
                return Integer.compare(this.r, o.r);
            }
            return Integer.compare(this.c, o.c);
        }
    }
}