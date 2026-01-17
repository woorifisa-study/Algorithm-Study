/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1620                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1620                           #+#        #+#      #+#    */
/*   Solved: 2026/01/16 06:50:58 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // 1. 자료구조 1개 사용
        // 번호-이름 순으로 map에 저장 후, key-value 순회 하면서 조회

        // 2. 자료구조 2개 사용
        // 번호-이름, 이름-번호 순으로 map 2개에 저장. 조회가 더 편하지만 저장 공간이 2개 필요함.

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 출력
        StringBuilder sb = new StringBuilder();

        // 자료구조
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // 포켓몬 개수 N, 문제 개수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            String name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if(input.matches("\\d+")){
              // 입력이 숫자이면
              int num = Integer.parseInt(input);
              sb.append(map1.get(num)).append("\n");
            } else {
              // 입력이 문자이면
              sb.append(map2.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }
}