package week03.jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_2578 {

    static class Point {
        int r;
        int c;

        Point (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Point> posMap = new HashMap();
        // 빙고판에 쓰여진 수 입력
        int[][] bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                posMap.put(num, new Point(i, j));
            }
        }

        // 사회자 입력 저장 배열
        int index = 0;
        int[] input = new int[25];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {               
                input[index++] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 수가 지워졌는지 체크하는 배열, 기본값 false / 수가 지워지면 true
        boolean[][] result = new boolean[5][5]; 
        for (int i = 0; i < 25; i++) {     
            
            Point p = posMap.get(input[i]);

            if(p != null) {
                
                result[p.r][p.c] = true;
    
                // 3줄 이상이면
                if (checkBingo(result) >= 3) {
                    System.out.println(i + 1);
                    return;
                }

            }
  
        }
    }
    
    public static int checkBingo(boolean[][] result) {
           
        int countLine = 0;
        boolean check = true;

        // 가로줄 검사
        for (int l = 0; l < 5; l++) {
            check = true;
            for (int m = 0; m < 5; m++) {
                if (result[l][m] == false) {
                    check = false;
                    break;
                }
            }
            if (check) countLine ++;
        }
    
        // 세로줄 검사
        for (int l = 0; l < 5; l++) {
            check = true;
            for (int m = 0; m < 5; m++) {
                if (result[m][l] == false) {
                    check = false;
                    break;
                }
            }
            if (check) countLine ++;
        }
    
        // 좌상향 대각선 검사
        check = true;
        for (int l = 0; l < 5; l++) {
            if (result[l][l] == false) {
                check = false;
                break;
            }
        }
        if (check) countLine ++;
    
        // 우상향 대각선 검사
        check = true;
        for (int l = 0; l < 5; l++) {
            if (result[l][4-l] == false) {
                check = false;
                break;
            }
        }
        if (check) countLine ++;


        return countLine;
    }
}
