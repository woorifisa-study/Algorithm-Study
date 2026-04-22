import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) { 
        
        int size = commands.length;

        int[] answer = new int[size];
        
        for(int n = 0; n < size; n++){
            
            int i = commands[n][0]; // i번째 숫자부터
            int j = commands[n][1]; // j번째 숫자까지
            int k = commands[n][2]; // k번째에 있는 수
            
            int[] new_arr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(new_arr);
            
            answer[n] = new_arr[k-1];
            
        }
        
        return answer;
    } 
}
