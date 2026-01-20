/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2578                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2578                           #+#        #+#      #+#    */
/*   Solved: 2026/01/20 08:03:56 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{

    static int count_line = 0;  // 완성된 줄
    static boolean[][] deleted; // 지운 칸

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[5][5];      // 빙고 판
        int[][] position = new int[26][2];  // 숫자 별 위치 (지울 때 사용)
        deleted = new boolean[5][5];

        int result = 0;

        // 빙고판 만들기
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                position[num][0] = i;
                position[num][1] = j;
            }
        }

        // deleted
        OUTER:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                int row = position[num][0];
                int col = position[num][1];

                deleted[row][col] = true;

                bingo(row, col);

                if(count_line >= 3){
                    result = 5 * i + j + 1; // N번째 지운 수
                    break OUTER;
                } 

            }
        }

        System.out.println(result);
    }


    public static void bingo(int row, int col){
        // 새로 지운 수가 빙고를 만드는지
        // 빙고 만들면 기존 count_line + 1

        int count = 0;

        // 대각선 \ 방향
        if(row == col){
            for (int i = 0; i < 5; i++) {
                if(deleted[i][i]) count++;
            }
            if(count == 5){
                count_line++;
            }
            count = 0;
        }

        // 대각선 / 방향
        if(row + col == 4){
            for (int i = 0; i < 5; i++) {
                if(deleted[i][4 - i]) count++;
            }
            if(count == 5){
                count_line++;
            }
            count = 0;
        }

        // 가로
        for (int i = 0; i < 5; i++) {
            if(deleted[row][i]) count++;
        }
        if(count == 5){
            count_line++;
        }
        count = 0;

        // 세로
        for (int i = 0; i < 5; i++) {
            if(deleted[i][col]) count++;
        }
        if(count == 5){
            count_line++;
        }
    }
}