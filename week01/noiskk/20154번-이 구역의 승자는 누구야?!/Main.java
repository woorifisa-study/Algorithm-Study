/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 20154                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/20154                          #+#        #+#      #+#    */
/*   Solved: 2026/01/08 17:15:43 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        // 문자별 획수
        int[] count = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        
        // 문자열 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        
        // 숫자 더하기
        int sum = 0;
        for(char c : s.toCharArray()){
            sum += count[c - 'A'];
        }

        // 홀수-짝수 판별
        sum %= 10;
        if(sum % 2 == 0){
            System.out.println("You're the winner?");
        } else {
            System.out.println("I'm a winner!");
        }

    }
}
