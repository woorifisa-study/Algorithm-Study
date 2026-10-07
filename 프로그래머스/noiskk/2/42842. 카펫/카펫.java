import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width, height;
        
        for(int i = 3; i < brown / 2; i++){
            width = i;
            height = (brown - 2 * i) / 2 + 2;
            if((width - 2) * (height - 2) == yellow){
                answer[0] = width;
                answer[1] = height;
            }
        }
        
        
        return answer;
    }
}