import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int length = cities.length;
        
        for (int i = 0; i < length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        // 캐시 사이즈가 0인 경우
        if (cacheSize == 0) {
            return length * 5;
        }
        
        
        Queue<String> cache = new LinkedList<>();
        int answer = 0;
        
        for (int i = 0; i < length; i++) {
            
            String city = cities[i];
            
            // cache hit
            if (cache.contains(city)) {
                answer += 1;
                
                // 캐시 업데이트
                cache.remove(city);
                cache.offer(city);
            }
                
            // cache miss
            else {
                answer += 5;
                if (!cache.isEmpty() && cache.size() >= cacheSize) cache.poll();
                cache.offer(city);
            }
        }
        
        return answer;
    }
}