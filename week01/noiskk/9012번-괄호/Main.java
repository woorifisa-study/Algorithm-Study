/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9012                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9012                           #+#        #+#      #+#    */
/*   Solved: 2026/01/08 19:46:24 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력 준비
        StringBuilder sb = new StringBuilder();

        // 테스트 데이터 수
        int T = Integer.parseInt(br.readLine());

        // 괄호 판별 테스트
        for (int i = 0; i < T; i++) {
            // 스택 (VPS 판별용)
            Stack<Character> stack = new Stack<>();

            char[] input = br.readLine().toCharArray();
            boolean valid = true;

            for (char c : input) {
                if(c == '(') {        // 여는 괄호
                    stack.push(c);
                } else if(!stack.isEmpty() && stack.peek() == '('){ // 닫는 괄호
                    stack.pop();
                } else {    // 여는 괄호 없이 닫을 때
                    valid = false;
                    break;
                }
            }

            if(valid && stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
            
        }

        System.out.println(sb);

    }
}