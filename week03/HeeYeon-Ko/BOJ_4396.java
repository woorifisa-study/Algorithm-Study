import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4396 {

    static int n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 시계방향(8방향)
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static char[][] mine; // 지뢰
    static char[][] opened; // 이미 열린 칸
    static char[][] result; // 정답
    static boolean isGameOver;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        mine = new char[n][n];
        opened = new char[n][n];
        result = new char[n][n];
        isGameOver = false;

        // 지뢰
        for (int i = 0; i < n; i++) {
            char[] ch = bf.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                mine[i][j] = ch[j];
            }
        }

        // 이미 열린칸
        for (int i = 0; i < n; i++) {
            char[] ch = bf.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                opened[i][j] = ch[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 지뢰 선택
                if(mine[i][j] == '*' && opened[i][j] == 'x'){
                    isGameOver = true;
                }
                else{
                    if(opened[i][j] == 'x'){
                        result[i][j] = mineCounter(i, j);
                    }
                    else{
                        result[i][j] = '.';
                    }
                }
            }
        }
        
        if(isGameOver){
            gameOver(); // 지뢰 출력
        }
        else{
            printResult(); // 결과 출력
        }


    }

    static void gameOver(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mine[i][j] == '*'){
                    result[i][j] = '*';
                }
            }
        }
        printResult();
    }

    static void printResult(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    static char mineCounter(int x, int y){
        int count = 0;

        for (int dir = 0; dir < 8; dir++) { // 8방향
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(mine[nx][ny] == '*') count++;
        }

        return (char) (count + '0');

    }
}
