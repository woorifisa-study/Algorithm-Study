import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        if (x == y) return 0;
        
        int[] dp = new int[y+1];
        Arrays.fill(dp, 1000005);
        
        dp[x] = 0;
        
        int nextNum;
        for (int i = x; i <= y; i++) {
            if (dp[i] == 1000005) continue;
            
            nextNum = i + n;
            if (nextNum <= y) dp[nextNum] = Math.min(dp[nextNum], dp[i] + 1);
            
            nextNum = i * 2;
            if (nextNum <= y) dp[nextNum] = Math.min(dp[nextNum], dp[i] + 1);
            
            nextNum = i * 3;
            if (nextNum <= y) dp[nextNum] = Math.min(dp[nextNum], dp[i] + 1);
        }
        
        if (dp[y] == 1000005) return -1;
        
        return dp[y];
        
    }    
}