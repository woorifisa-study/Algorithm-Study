import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        
        // 참가 선수 map에 저장
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // map에서 완주 못한 선수 제거
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
            if (map.get(name) == 0) map.remove(name);
        }
        
        return map.keySet().iterator().next();
    }
}