/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18258                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18258                          #+#        #+#      #+#    */
/*   Solved: 2026/01/06 23:27:02 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());

    Deque<Integer> deque = new ArrayDeque<>();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();
      switch(cmd){
        case "push":
          deque.offerLast(Integer.parseInt(st.nextToken()));
          break;
        
        case "pop":
          sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
          break;
          
        case "size":
          sb.append(deque.size()).append('\n');
          break;

        case "empty":
          sb.append(deque.isEmpty() ? 1 : 0).append('\n');
          break;

        case "front":
          sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
          break;

        case "back":
          sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
          break;

      }
    }
  
    System.out.print(sb);
  }
}