package week05.jeeneep;

import java.io.*;
import java.util.*;

// 2503
public class BOJ_2503 {

    // 123 ~ 987 사이 수의 가능 여부를 저장하는 배열 
    static boolean[] isPossible = new boolean[1000];

    // 질문한 숫자, 스트라이크 개수, 볼 개수를 저장하는 클래스
    static class Info {
        int num;
        int S; 
        int B; 

        public Info(int num, int S, int B) {
            this.num = num;
            this.S = S;
            this.B = B;
        }
    }
    public static void main(String[] args) throws IOException {

        // isPossible 배열 초기화 -> 0이 포함되지 않고, 서로 다른 숫자 세 개로 구성된 경우만 true
        for (int i = 123; i < 988; i++) {
            int first = i / 100;
            int second = i / 10 % 10;
            int third = i % 10;

            if (second != 0 && third != 0 && first != second && first != third && second != third) {
                isPossible[i] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Info> infos = new ArrayList<Info>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            infos.add(new Info(num, strike, ball));
        }
        
        int totalCount = 0;
        for (int i = 123; i <= 987; i++) {
            if (isPossible[i]) {
                for (Info info : infos) {
                    int S = countStrike(info.num, i);
                    int B = countBall(info.num, i);

                    if (info.S != S || info.B != B) {
                        isPossible[i] = false;
                    }          
                }                       
            }
            if (isPossible[i]) totalCount++;
        }

        System.out.println(totalCount);

    }

    public static int countStrike (int input, int i) {
        int strike = 0;

        if (input % 10 == i % 10) strike++;
        if (input / 10 % 10 == i / 10 % 10) strike++;
        if (input / 100 % 10 == i / 100 % 10) strike++;

        return strike;
    }

    public static int countBall(int input, int i) {
        int ball = 0;
        
        int[] nums_i = new int[3];
        nums_i[0] = i / 100;
        nums_i[1]  = i / 10 % 10;
        nums_i[2]  = i % 10;


        int[] nums_index = new int[3];
        nums_index[0] = input / 100;
        nums_index[1]  = input / 10 % 10;
        nums_index[2]  = input % 10;
        
        if (nums_index[0] == nums_i[1] || nums_index[0] == nums_i[2]) ball++;
        if (nums_index[1] == nums_i[0] || nums_index[1] == nums_i[2]) ball++;
        if (nums_index[2] == nums_i[0] || nums_index[2] == nums_i[1]) ball++;

        return ball;
    }
 
}