/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 22858                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/22858                          #+#        #+#      #+#    */
/*   Solved: 2026/01/23 06:38:26 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 카드 개수 N
        int K = Integer.parseInt(st.nextToken()); // 카드 섞은 횟수 K

        // 배열S : 카드 섞은 후 배치 순서
        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }


        // 배열D : 셔플 규칙 정보
        int[] D = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }


        // 배열P : 셔플 전 순서
        int[] P = new int[N];

        // K만큼 역셔플
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
                P[D[i] - 1] = S[i];
            }
            S = P.clone();
        }
        

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }

        System.out.println(sb);


    }
}