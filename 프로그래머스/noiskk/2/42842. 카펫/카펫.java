import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        // (가로 - 2) x (세로 - 2) = yellow
        // (가로 x 2) + (세로 x 2) - 4 = brown
        
        for(int length = 3; length < 2500; length++){
            for(int width = length; width < 2500; width++){
                if((length - 2) * (width - 2) == yellow && length * 2 + width * 2 - 4 == brown){
                    answer[0] = width;
                    answer[1] = length;
                }
            }
        }
        
        return answer;

    }
}