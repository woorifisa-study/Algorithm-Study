import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][];
        
        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            dp[i] = new int[triangle[i].length];
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            for(int j = 1; j < triangle[i].length-1; j++){
                int left = dp[i-1][j-1];
                int right = dp[i-1][j];
                
                dp[i][j] = Math.max(left + triangle[i][j], right + triangle[i][j]);
            }
            
            dp[i][triangle[i].length-1] = 
                dp[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-1];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < dp[triangle.length-1].length; i++){
            if(max < dp[triangle.length-1][i]){
                max = dp[triangle.length-1][i];
            }
        }
        
        return max;
    }
}