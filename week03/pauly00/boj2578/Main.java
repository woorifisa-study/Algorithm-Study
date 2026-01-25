import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[5][5]; // 원래 보드판
        for(int i=0; i<5; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<5; j++){  // 빙고판 제작
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        boolean[][] bingo = new boolean[5][5]; // 빙고판 결과
        int ans = 0; // 출력 값
        
        for(int i=0;i<5;i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<5;j++){
                int num = Integer.parseInt(tmp[j]);
                ans++; // 숫자 부름

                for (int x=0; x<5; x++) {
                    for(int y=0; y<5; y++) {
                        if(board[x][y]==num) {
                            bingo[x][y]=true; // 해당하는 값 체크
                        }
                    }
                }

                int bingoCount = 0; // 빙고 개수
                // 가로줄
                for(int r=0; r<5; r++) {
                    boolean isLineBingo=true; // 한줄빙고 여부
                    for(int c=0; c<5; c++){
                        if(!bingo[r][c]) {
                            isLineBingo=false;
                            break;
                        }
                    }
                    if(isLineBingo) bingoCount++;
                }

                // 세로줄
                for (int c=0; c<5; c++) {
                    boolean isLineBingo = true;
                    for(int r=0; r<5; r++) { // 반복문을 반대로
                        if(!bingo[r][c]) {
                            isLineBingo=false;
                            break;
                        }
                    }
                    if(isLineBingo) bingoCount++;
                }

                // 대각선줄 (오른쪽아래 방향)
                boolean isLineBingo = true;
                for(int x=0; x<5; x++) {
                    if(!bingo[x][x]) {
                        isLineBingo=false;
                        break;
                    }
                }
                if(isLineBingo) bingoCount++;

                // 대각성줄(왼쪽아래 방향)
                isLineBingo = true;
                for(int x=0; x<5; x++) {
                    if(!bingo[x][4-x]) {
                        isLineBingo=false;
                        break;
                    }
                }
                if(isLineBingo) bingoCount++;
            
                if(bingoCount >=3) { // 빙고 3개
                    System.out.println(ans);
                    return;
                }
            }
        }
    }
}