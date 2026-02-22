
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* ************************************************************************** */
 /*                                                                            */
 /*                                                      :::    :::    :::     */
 /*   Problem Number: 4796                              :+:    :+:      :+:    */
 /*                                                    +:+    +:+        +:+   */
 /*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
 /*                                                  +#+      +#+        +#+   */
 /*   https://boj.kr/4796                           #+#        #+#      #+#    */
 /*   Solved: 2026/02/20 16:25:45 by zionzion00    ###          ###   ##.kr    */
 /*                                                                            */
 /* ************************************************************************** */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int caseNum = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken()); // 사용가능한 날짜 
            int P = Integer.parseInt(st.nextToken()); // 연속된 날짜 
            int V = Integer.parseInt(st.nextToken()); // 휴가 기간

            if (L == 0 && P == 0 & V == 0) {
                break;
            }

            int result = 0;

            /*
            L 사용가능한 날짜 
            P 연속된 날짜 
            V 휴가 기간
            5 8 20

            휴가 20일 -> 5 / 3 / 5 / 3 / 4

            남은 휴가가 P보다 크면 계속 반복
                V -= P (휴가에서 연속된 날짜 뺌)
                result += L (사용가능한 날짜 더함)
            result + 남은 휴가 (사용가능한 날짜가 더 짧을 수도 있음)
        
             */
            while (V >= P) {
                V -= P;
                result += L;
            }

            result += Math.min(L, V);

            System.out.println("Case " + caseNum + ": " + result);
            caseNum++;
        }

    }
}
