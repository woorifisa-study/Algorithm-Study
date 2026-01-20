package week03.jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_4396 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 상 하 좌 우 대각선
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        boolean bomb = false;
        // 지뢰의 위치 입력
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 열린 칸인지 여부 입력
        char[][] open = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                open[i][j] = line.charAt(j);

                // 열린 칸 + 지뢰있는 칸 
                if (open[i][j] == 'x' && map[i][j] == '*') bomb = true;
            }
        }


        // 결과 저장 배열
        char[][] result = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 지뢰 없으면서 열린 칸
                if (map[i][j] == '.' && open[i][j] =='x') {
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int row = i + dx[k];
                        int col = j + dy[k];
                        
                        if ( row < 0 || row >= n || col < 0 || col >= n) continue;
                        if ( map[row][col] == '*') count++;
                    }
                    result[i][j] = (char)(count + '0');
                }
                else result[i][j] = '.'; 
            }   

        }

        
        // 지뢰가 열렸다면 지뢰 위치 * 덮어쓰기
        if (bomb) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') result[i][j] = '*';
                }
            }
        }
        

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        
        }
        System.out.println(sb);
    }
    
}
