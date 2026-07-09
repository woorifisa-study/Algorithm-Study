import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> answer = new ArrayList<>(); 
        
        // 사전 초기화
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char)('A' + i)), (i + 1));
        }
        
        int nextIndex = 27;
        String w = "";
        for (int i = 0; i < msg.length(); i++) {
            
            String c = String.valueOf(msg.charAt(i));
            String wc = w + c;
            
            if (dictionary.containsKey(wc)) { 
                w = wc; // 사전에 존재하면 w를 wc로 업데이트
            }
            else {
                answer.add(dictionary.get(w));
                dictionary.put(wc, nextIndex++);
                w = c;
            }
        }
        
        // 마지막 출력인 경우
        if (!w.isEmpty()) answer.add(dictionary.get(w));
        
        return answer.stream().mapToInt(i -> i).toArray(); 
    }
}