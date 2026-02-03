package week03.jeeneep;

import java.io.*;
import java.util.*;


// 1780
public class BOJ_1780 {

    static int[][] paper; // N × N 크기의 행렬 저장
    static int minusOne = 0, zero = 0, plusOne = 0; // -1, 0, 1 개수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // paper 배열에 숫자 저장
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);
       
        StringBuilder sb = new StringBuilder();
        sb.append(minusOne).append("\n");
        sb.append(zero).append("\n");
        sb.append(plusOne);

        // 출력
        System.out.println(sb);
    }

    // 종이가 모두 같은 수로 되어 있는지 체크
    public static boolean isSame (int row, int col, int size) {

        int checkNum = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if ( paper[i][j] != checkNum) return false;
            }
        }

        return true;
    }

    public static void divide(int r, int c, int size) {
        // 현재 영역이 모두 같은지 확인
        if (isSame(r, c, size)) {
    
            // 같은 수로 되어있으면 카운트 올리고 종료
            int num = paper[r][c];
            if (num == -1) minusOne++;
            else if (num == 0) zero++;
            else plusOne++;
            
            return; 
        }

        // 현재 영역이 모두 같지 않으면 -> 9등분
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(r + i * newSize, c + j * newSize, newSize);
            }
        }

    }
    
}
