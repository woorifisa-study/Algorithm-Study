/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4396                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4396                           #+#        #+#      #+#    */
/*   Solved: 2026/01/19 06:35:30 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;

public class Main{

    static int N;
    static boolean[][] bomb;
    static boolean gameOver = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        bomb = new boolean[N][N];

        char[][] result = new char[N][N];

        for (int i = 0; i < N; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < N; j++) {
                if(inputLine.charAt(j) == '*') bomb[i][j] = true;
                else bomb[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < N; j++) {
                if(inputLine.charAt(j) == 'x'){
                    // check
                    result[i][j] = Integer.toString(check(i, j)).charAt(0);
                } else {
                    result[i][j] = '.';
                }
            }
        }

        if(gameOver){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(bomb[i][j]){
                        result[i][j] = '*';
                    }
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);

    }


    public static int check(int x, int y){
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};

        int count = 0;

        if(bomb[x][y]){
            gameOver = true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            for (int j = 0; j < 3; j++) {
                int ny = y + dy[j];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(bomb[nx][ny] == true) count++;
                }
            }
        }

        return count;
    }
}