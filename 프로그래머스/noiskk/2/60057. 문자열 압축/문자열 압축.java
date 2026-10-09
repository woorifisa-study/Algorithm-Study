import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
            
        for(int unit = 1; unit <= len / 2; unit++){
            StringBuilder sb = new StringBuilder(); // 압축 결과용
            String prev = "";
            int count = 1;
            
            for(int i = 0; i < len; i += unit){
                
                String cur = s.substring(i, Math.min(i + unit, len));
                
                if(cur.equals(prev)){
                    count++;
                } else {
                    if(count > 1) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            
            if(count > 1) sb.append(count);
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
            
        }
        
        return answer;
    }
}

