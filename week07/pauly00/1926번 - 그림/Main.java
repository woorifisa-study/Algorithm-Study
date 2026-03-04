import java.io.*;
import java.util.*;

public class Main {
    static int drawingNum=0; // 그림개수
    static int longestDrawing=0; // 그림 넓이
    static int[][] drawings; // 원본 그림
    static Queue<int[]> drawingQueue; // 그림 확장용 좌표저장큐
    static boolean[][] isVisited; // 방문 여부
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        drawings = new int[n][m];
        isVisited = new boolean[n][m];

        drawingQueue = new LinkedList<>();
        dx = new int[]{0,0,-1,1};
        dy = new int[]{-1,1,0,0};

        for(int i=0; i<n; i++) {
            tmp = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                drawings[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!isVisited[i][j] && drawings[i][j] ==1){
                    BFS(i, j);
                }
            }
        }

        System.out.println(drawingNum);
        System.out.println(longestDrawing);
    }

    public static void BFS(int n, int m) {
        drawingNum++;
        int area=0; // 현재 그림의 넓이
        drawingQueue.offer(new int[]{n,m});
        isVisited[n][m] = true;
        while(!drawingQueue.isEmpty()) {
            int[] cur = drawingQueue.poll();
            area++;
            for(int i=0; i<4; i++) {
                // 현재 위치에서 상하좌우 이동
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx>=0 && nx<drawings.length && // x 범위
                    ny>=0 && ny<drawings[0].length && // y 범위
                    drawings[nx][ny] ==1 && // 색칠된 부분
                    !isVisited[nx][ny]){ // 방문안함
                    isVisited[nx][ny]= true;
                    drawingQueue.add(new int[]{nx,ny});
                }
            }
        }

        longestDrawing = Math.max(longestDrawing, area);
    }
}