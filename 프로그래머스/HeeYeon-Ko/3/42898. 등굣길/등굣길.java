class Solution {
    public int solution(int m, int n, int[][] puddles) { 
        
        int[][] board = new int[n+1][m+1]; // 격자
        boolean[][] flood = new boolean[n+1][m+1]; // 물 웅덩이 위치
        int mod = 1000000007;
        
        for(int[] puddle : puddles){
            flood[puddle[1]][puddle[0]] = true; // 물 웅덩이 위치 저장
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(flood[i][j]){
                    board[i][j] = 0;
                    continue;
                }
                if(i == 1 && j == 1){
                    board[i][j] = 1;
                }
                else if(i == 1 && j > 1){
                    board[i][j] = board[i][j-1] % mod;
                }
                else if(j == 1 && i > 1){
                    board[i][j] = board[i-1][j] % mod;
                }
                else{
                    board[i][j] = (board[i][j-1] + board[i-1][j]) % mod;    
                }
            }
        }
        
        return board[n][m];
    }
}