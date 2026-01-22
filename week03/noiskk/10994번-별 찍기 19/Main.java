/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10994                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10994                          #+#        #+#      #+#    */
/*   Solved: 2026/01/22 06:54:46 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 1 5 9 13 17 ... 
        // 4씩 증가
        // 4n - 3

        int size = 4 * N - 3;
        char[][] map = new char[size][size];

        // 배열 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = ' ';
            }
        }

        for (int i = 0; i < N; i++) {
            int start = 2 * i;
            int end = size - 1 - 2 * i;

            // 위아래
            for (int j = start; j <= end; j++) {
                map[start][j] = '*';
                map[end][j] = '*';
            }

            // 왼쪽 오른쪽
            for (int j = start; j <= end; j++) {
                map[j][start] = '*';
                map[j][end] = '*';
            }

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }


        System.out.println(sb);
        
        

    }

}