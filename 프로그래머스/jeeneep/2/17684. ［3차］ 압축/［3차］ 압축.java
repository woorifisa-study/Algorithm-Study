import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        // 사전 초기화
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char)('A' + i)), (i+1));
        }
        
        List<Integer> result = new ArrayList<>(); 
        
        int i = 0;
        while (i < msg.length()) {
            
            // w에 글자 붙이기
            int j = 1;
            String current = ""; // 가장 긴 단어 보관
            int indexNum = 0; // 가장 긴 단어의 색인 번호 보관
            String next = ""; // 검사할 w + c 보관   
            while (i + j <= msg.length()) {

                next = msg.substring(i, i + j);
                if (dictionary.containsKey(next)) {
                    current = next;
                    indexNum = dictionary.get(current);
                    j++;
                }
                else break;
            }
            // 새로운 단어 사전에 넣기
           if (!dictionary.containsKey(next)) {
                dictionary.put(next, dictionary.size() + 1);
            }
            // 색인 번호 리스트 추가
            result.add(indexNum);
            // i 업데이트
            i += current.length();
            
        }
                
        int[] answer = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k);
        }
        
        return answer; 
    }
}