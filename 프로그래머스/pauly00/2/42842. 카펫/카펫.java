import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int w=0, h=0;
        int[] ansArr = new int[2];
        
        int diff = Integer.MAX_VALUE;
        
        for(h=2; h<=sum/2; h++) {
            if(sum%h ==0) {
                w=sum/h;
                if((w-2) * (h-2) == yellow) {
                    ansArr[0] = w;
                    ansArr[1] = h;
                    return ansArr;
                }
            }
        }
        return ansArr;
    }
}