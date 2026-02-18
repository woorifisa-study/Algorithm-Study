/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2503                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2503                           #+#        #+#      #+#    */
/*   Solved: 2026/02/12 18:29:46 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static class Question{
        int[] num = new int[3];
        int strike;
        int ball;

        public Question(int[] num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Question[] questions = new Question[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            String s = st.nextToken();
            int[] num = new int[3];

            num[0] = s.charAt(0) - '0';
            num[1] = s.charAt(1) - '0';
            num[2] = s.charAt(2) - '0';

            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            questions[i] = new Question(num, strike, ball);
        }

        int answer = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if(i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    if(i == k || j == k) continue;

                    int[] candidate = {i, j, k};
                    boolean isValid = true;
                    
                    for(Question q : questions){
                        int strike = 0;
                        int ball = 0;

                        // 스트라이크 계산
                        if(candidate[0] == q.num[0]) strike++;
                        if(candidate[1] == q.num[1]) strike++;
                        if(candidate[2] == q.num[2]) strike++;

                        // 볼 계산
                        if(candidate[0] == q.num[1] || candidate[0] == q.num[2]) ball++;
                        if(candidate[1] == q.num[0] || candidate[1] == q.num[2]) ball++;
                        if(candidate[2] == q.num[0] || candidate[2] == q.num[1]) ball++;

                        // 조건 불일치
                        if(strike != q.strike || ball != q.ball){
                            isValid = false;
                            break;
                        }
                    }

                    if(isValid) answer++;
                }
            }
        }

        System.out.println(answer);

    }
}