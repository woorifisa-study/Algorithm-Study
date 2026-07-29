import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        // 1 2 3 5
        // 5 6 7 8
        // 4 3 2 1 
        
        // 합산하면서 내려오기
        
        for(int row = 1; row < land.length; row++){
            land[row][0] += Math.max(
                Math.max(land[row - 1][1], land[row - 1][2]), 
                land[row - 1][3]
            );
            
            land[row][1] += Math.max(
                Math.max(land[row - 1][0], land[row - 1][2]), 
                land[row - 1][3]
            );
            
            land[row][2] += Math.max(
                Math.max(land[row - 1][0], land[row - 1][1]), 
                land[row - 1][3]
            );
            
            land[row][3] += Math.max(
                Math.max(land[row - 1][0], land[row - 1][1]), 
                land[row - 1][2]
            );
        }
        
        int answer = Math.max(
            Math.max(land[land.length - 1][0], land[land.length - 1][1]), 
            Math.max(land[land.length - 1][2], land[land.length - 1][3])
        );
        
        return answer;
    }
}