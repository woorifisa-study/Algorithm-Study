/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10866                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10866                          #+#        #+#      #+#    */
/*   Solved: 2026/01/08 18:54:44 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        // deque 정의
        Deque<Integer> deque = new ArrayDeque<>();

        // 입력 받을 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 출력 준비
        StringBuilder sb = new StringBuilder();

        // 명령 횟수 입력 받기
        int N = Integer.parseInt(st.nextToken());

        // 명령 수행
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;

                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                    break;
                    
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;

                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}