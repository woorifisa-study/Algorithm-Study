import java.io.*;
import java.util.*;

public class Main {
    static int[][] maze;
    static boolean[][] isVisited;
    static Queue<int[]> mazeQueue; // 좌표 형태의 큐
    // 이동 방향 정의
    static int[] dx;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        maze = new int[n][m];
        isVisited = new boolean[n][m];

        mazeQueue = new ArrayDeque<>();
        // 왼, 오, 아래, 위(방향을 세트로 저장)
        dx = new int[]{0,0,-1,1};
        dy = new int[]{-1,1,0,0};

        for(int i=0; i<n; i++) {
            tmp[0]=br.readLine(); // 띄어쓰기 없음
            for(int j=0; j<m; j++) {
                maze[i][j] = tmp[0].charAt(j)-'0'; // 문자로 나눔
            }
        }
        
        BFS(n, m);
        System.out.println(maze[n-1][m-1]);

    }

    public static void BFS(int n, int m) {

        mazeQueue.offer(new int[]{0,0}); // add와 동일
        isVisited[0][0] = true;

        while(!mazeQueue.isEmpty()) {
            int[] current = mazeQueue.poll();
            int x = current[0];
            int y = current[1];

            for(int i=0; i<4; i++) {
                // 이동한 좌표
                int movedX = x+ dx[i];
                int movedY = y+ dy[i];

                if(movedX>= 0&& movedX<n&& movedY>=0 && movedY<m &&
                    maze[movedX][movedY] == 1 && !isVisited[movedX][movedY]) {
                    isVisited[movedX][movedY]=true;
                    mazeQueue.add(new int[]{movedX, movedY}); // 2개를 묶은 배열 생성
                    maze[movedX][movedY] = maze[x][y] +1;
                }
            }
        }
    }
}