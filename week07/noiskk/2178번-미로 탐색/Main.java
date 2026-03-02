
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2178                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2178                           #+#        #+#      #+#    */
/*   Solved: 2026/03/01 14:26:04 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/**
 * visited[] 만들고, 
 * visited 랑 기존 board 확인해서 갈 수 있는 곳은 가기.
 * 
 */

public class Main{

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        System.out.println(bfs());

    }

    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            // 도착
            if(cur.x == N - 1 && cur.y == M - 1){
                return cur.dist;
            }

            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, cur.dist + 1));
            }
        }

        return 0;
    }

    
}
