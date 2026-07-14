import java.util.*;

class Solution {
    
    static int currentCount = 0;
    static int answerCount = 0;
    static String vowel = "AEIOU";
    static boolean find = false;
    
    public int solution(String word) {
                
        dfs("", word);
        return answerCount;
    }
    static void dfs(String currentWord, String answerWord) {
            
        if (find || currentWord.length() >= 5) return;
        
        else {
            for (int i = 0; i < 5; i++) {
                
                // 다음 단어 만들기
                String nextWord = currentWord + vowel.charAt(i);
                currentCount++;
                
                // 다음 단어가 정답인 경우
                if (nextWord.equals(answerWord)) {
                    answerCount = currentCount;
                    find = true;
                    return;
                }
                
                dfs(nextWord, answerWord);
            }
        }
        
    }
}