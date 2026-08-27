import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Object[]> q = new ArrayDeque<>(); // 여러 타입의 값 묶기
        boolean[] isVisited = new boolean[words.length];
        
        // {단어, 변환 횟수}
        q.add(new Object[]{begin, 0});
        
        while(!q.isEmpty()) {
            Object[] cur = q.poll();
            
            // 값 추출 후 형변환(Object로 명시되었으므로)
            String word = (String) cur[0];
            int count = (int) cur[1];
            
            // 타겟과 일치
            if(word.equals(target)) {
                return count;
            }
            
            for(int i=0; i< words.length; i++) {
                // 현재 word와 한글자만 다른 단어 찾기                
                if(!isVisited[i] && canChange(word, words[i])) {
                    isVisited[i] = true; // 방문여부
                    q.add(new Object[]{words[i], count+1});
                }
            }
        }
        return 0;
    }
    
    public boolean canChange(String a, String b) {
        int diff = 0;
        // 두 문자열 비교 후
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) diff++;
        }
        
        // 다른 글자가 정확히 1개인지
        return diff == 1;
        
    }
}