import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int a=0; a<commands.length; a++) {
            int i = commands[a][0] -1; // 배열 기준으로 맞추기
            int j = commands[a][1] -1;
            int k = commands[a][2] -1;
            
            ArrayList<Integer> tmpArray = new ArrayList<>();
            
            for(int b=i; b<=j; b++) {
                tmpArray.add(array[b]);
            }
            Collections.sort(tmpArray);
            answer[a] = tmpArray.get(k); // k번째 값 추출
        }
        
        return answer;
    }
}