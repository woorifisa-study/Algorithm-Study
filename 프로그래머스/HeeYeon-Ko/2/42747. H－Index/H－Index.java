import java.util.*;

class Solution {
    public int solution(int[] citations) {
        //int answer = 0;
        
        // [3, 0, 6, 1, 5]
        // -> [0, 1, 3, 5, 6] 정렬
        Arrays.sort(citations);
        
        int h = 0;
        int max_h = Integer.MIN_VALUE;
        
        // 사이즈 5
        for(int n = 0; n<=citations[citations.length-1]; n++) {
            
            for(int i = 0; i<citations.length; i++){
                int up_size = 0;
                int down_size = 0; 
                
                if(n <= citations[i]){
                    up_size = citations.length - i;
                }
                else if(n >= citations[i]){
                    down_size = i + 1;
                }
                
                if(up_size >= n && down_size <= n){
                    h = n;
                }
                
                if(h > max_h){
                    max_h = h;
                }
            }
        }
        
        return max_h;
    }
}