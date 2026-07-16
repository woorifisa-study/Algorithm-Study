import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        
        // 0 0 0 0 0 
        // 0 0 1 0 3
        // 0 2 5 0 1
        // 4 2 4 4 2
        // 3 5 1 3 1
        
        // 뽑은 인형 담는 바구니
        Stack<Integer> bucket = new Stack<>();
        
        int row = board.length;
        int col = board[0].length;
        Stack<Integer>[] board_stack = new Stack[col];
        
        int answer = 0;
        
        for(int i = 0; i < col; i++){
            board_stack[i] = new Stack<>();
            
            for(int j = row - 1; j >= 0; j--){
                if(board[j][i] != 0){
                    board_stack[i].push(board[j][i]);
                }
            }
        }
        
        for(int move : moves){
            if(!board_stack[move - 1].isEmpty()){
                int target = board_stack[move - 1].pop();
                if(!bucket.isEmpty() && bucket.peek() == target){
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(target);
                }
            }
        }
        
        return answer;
    }
}