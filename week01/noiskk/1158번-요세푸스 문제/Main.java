/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1158                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1158                           #+#        #+#      #+#    */
/*   Solved: 2026/01/09 08:17:03 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 출력 준비
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 자료구조 정의
        Deque<Integer> deque = new ArrayDeque();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // deque 에 숫자 N개 넣기
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }
        
        while(!deque.isEmpty()){
            // K-1만큼 뺐다가 다시 삽입
            for(int i = 0; i < K - 1; i++){
                deque.offer(deque.poll());
            }
            // K번째 수 출력
            sb.append(deque.poll()).append(", ");
        }

        // 마지막 ", " 지우기
        sb.delete(sb.length() - 2, sb.length());

        // 출력 형식 완성
        sb.append(">");

        System.out.println(sb);
    }
}