import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        // map 에 A:1 ~ Z:26 까지 넣기
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(String.valueOf(c), c - 'A' + 1);
        }
        
        int nextIndex = 27;
        
        String w = "";
        
        for(int i = 0; i < msg.length(); i++){
            
            String c = String.valueOf(msg.charAt(i));
            
            String wc = w + c;
            
            if(map.containsKey(wc)){ // map 에 있으면 다음 글자까지 추가
                w = wc;
            } else {
                answer.add(map.get(w));
                map.put(wc, nextIndex++);
                w = c;
            }
        }
        
        if(!w.isEmpty()){ // 마지막 출력
            answer.add(map.get(w));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
