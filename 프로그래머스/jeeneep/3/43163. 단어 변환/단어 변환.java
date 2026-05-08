import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        
        // words 배열 안에 target 단어가 없으면 0 반환
        int is_same = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) is_same = 1;
        }
        if (is_same == 0) return 0;
        
        Queue<Word> queue = new ArrayDeque<>();
                
        queue.add(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word current = queue.poll();
            
            if (target.equals(current.word)) return current.stage;
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(words[i], current.word)) {
                    visited[i] = true;
                    queue.add(new Word(words[i], current.stage + 1));
                }
            }
        }
        
        return answer;
    }
    
    // 한 글자만 다를 때 true 반환
    boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
    
    class Word {
        String word;
        int stage;
        Word(String word, int stage) {
            this.word = word;
            this.stage = stage;
        }
    }
}