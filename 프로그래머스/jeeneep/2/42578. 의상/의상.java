import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // 의상 종류별로 개수를 저장
        HashMap<String, Integer> map = new HashMap<>();
        
        // 의상 배열을 돌면서 종류별 개수 카운트
        for (String[] cloth : clothes) {
            String type = cloth[1]; 
            
            // map.put(type, map.getOrDefault(type, 0) + 1);
            if (map.containsKey(type)) {
                map.put(type, map.get(type) + 1);
            } else {
                map.put(type, 1);
            }
        }
        
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        // 모두 0인 경우 1 빼기
        answer--;
        
        return answer;
    }
}
