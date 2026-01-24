import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {

    static int[][] board;
    static int[][] calledNum;
    static boolean[][] bingo;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        calledNum = new int[5][5];
        bingo = new boolean[5][5];
        int count = 0;
        int order = 0;

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자가 부르는 수 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                calledNum[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                order++; // 몇 번째 수인지 계산
                if(play(calledNum[i][j])){
                    count +=
                            isWidthBingo(x, y) + isHeightBingo(x, y) + isRightDiagonalBingo(x, y) + isLeftDiagonalBingo(
                                    x, y);

                }
                if(count>=3){
                    System.out.println(order);
                    return;
                }

            }
        }

    }

    // 빙고판 색칠
    static boolean play(int num){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(board[i][j] == num){
                    x = i;
                    y = j;
                    bingo[x][y] = true;
                    return true;
                }
            }
        }
        return false;
    }


    // 가로 빙고
    static int isWidthBingo(int x, int y){
        for (int j= 0; j < 5; j++) {
            if(!bingo[x][j]){
                return 0;
            }
        }
        return 1;
    }

    // 세로 빙고
    static int isHeightBingo(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if (!bingo[i][y]) {
                return 0;
            }
        }
        return 1;
    }

    // 왼쪽 대각선 빙고
    static int isLeftDiagonalBingo(int x, int y) {
        if(x == y){
            for (int i = 0; i < 5; i++) {
                if(!bingo[i][i]){
                    return 0;
                }
            }
            return 1;
        }
        else{
            return 0;
        }

    }

    // 오른쪽 대각선 빙고
    static int isRightDiagonalBingo(int x, int y) {
        if(x + y == 4){
            for (int i = 0; i < 5; i++) {
                if(!bingo[i][4-i]){
                    return 0;
                }
            }
            return 1;
        }
        else{
            return 0;
        }
    }
}
