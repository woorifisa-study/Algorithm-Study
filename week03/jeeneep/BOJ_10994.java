package week03.jeeneep;

import java.io.*;
import java.util.*;

// 10994
public class BOJ_10994 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] stars = new char[ 4*n-3 ][ 4*n-3 ];

        // 배열을 공백으로 채워 초기화하기
        for (int i = 0; i < stars.length; i++) {
            Arrays.fill(stars[i], ' ');        
        }       

        // 사각형의 시작점 (0, 0)
        int s = 0;
        // 그리려는 사각형의 길이
        int len = 4 * n - 3;

        while (len > 0) {

            // 윗변 & 아랫변 그리기
            for (int j = s; j < s + len; j++ ) {
                stars[s][j] = '*';
                stars[s + len - 1][j] = '*';
            }

            // 왼쪽변 & 오른쪽 그리기
            for (int i = s; i < s + len; i++) {
                stars[i][s] = '*';
                stars[i][s + len - 1] = '*';
            }
  
            // 다음 안쪽 사각형 준비
            s += 2;
            len -= 4;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars.length; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
