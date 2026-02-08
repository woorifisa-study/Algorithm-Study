/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1780                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1780                           #+#        #+#      #+#    */
/*   Solved: 2026/02/02 18:37:24 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int[][] paper;
    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);

    }

    // row, col -> 시작좌표 (왼쪽 위)
    static void divide(int row, int col, int size){
        int num = paper[row][col];

        boolean isVaild = true;

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(paper[i][j] != num){
                    isVaild = false;
                }                    
            }
        }

        if(!isVaild){
            // 숫자 섞여있음
            int newSize = size / 3;

            divide(row, col, newSize);
            divide(row, col + newSize, newSize);
            divide(row, col + newSize * 2, newSize);

            divide(row + newSize, col, newSize);
            divide(row + newSize, col + newSize, newSize);
            divide(row + newSize, col + newSize * 2, newSize);

            divide(row + newSize * 2, col, newSize);
            divide(row + newSize * 2, col + newSize, newSize);
            divide(row + newSize * 2, col + newSize * 2, newSize);
            
        } else {
            // 숫자 안 섞임
            if(num == -1) minusOne++;
            else if(num == 0) zero++;
            else plusOne++;
        }

    }
}