package week07.jeeneep;

import java.io.*;
import java.util.*;

// 2178 
public class BOJ_2178 {

    // 미로 정보 저장
    static int[][] map;

    static int N, M;

    // 행(row) 이동: 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    // 열(col) 이동: 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 입력 받기 
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {

            Point cur = q.poll();

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 1) { // 길이고, 아직 방문하지 않았으면
                        map[nr][nc] = map[cur.r][cur.c] + 1; // 거리 업데이트
                        q.add(new Point(nr, nc));
                    }
                }
            }            
        }
         
        System.out.println(map[N-1][M-1]);

    }

    // 좌표 저장 클래스
    static class Point {
        int r, c;
        Point(int r, int c) { 
            this.r = r; 
            this.c = c; 
        }
    }
}
