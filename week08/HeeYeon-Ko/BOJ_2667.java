import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667{
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[][] map = new int[N][N]; 
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0}; //상우하좌
        int[] dy = {0, 1, 0, -1}; //상우하좌

        for ( int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }

        int count = 0; // 단지수
        List<Integer> answer = new ArrayList<>();
        
        
        for ( int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               // 이미 방문했거나 0인 경우
               if(visited[i][j] || map[i][j] == 0){
                   continue;
               }

               queue.add(new Point(i,j));
               visited[i][j] = true;
               count++;
               int size = 0; // 단지내 집의 수

               while(!queue.isEmpty()){
                    Point point = queue.poll();
                    size++;

                    for (int d = 0; d < 4; d++) {
                        int nx = point.x + dx[d];
                        int ny = point.y + dy[d];

                        // 범위 확인 
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                            continue;
                        }
                        // 이미 방문했거나 0인 경우
                        if(visited[nx][ny] || map[nx][ny] == 0){
                            continue;
                        }

                        queue.add(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
                answer.add(size);
            }
        }
        
        Collections.sort(answer);
        
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(answer.get(i));
        }

    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
