import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> genres_order = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> plays_order = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            if(!genres_order.containsKey(genres[i])){ // 해당 키가 존재하지 않을 경우
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]); // 인덱스 : 재생 횟수
                plays_order.put(genres[i], map);
                genres_order.put(genres[i], plays[i]);
            }
            else{ // 해당 키가 존재할 경우
                plays_order.get(genres[i]).put(i, plays[i]);
                genres_order.put(genres[i], genres_order.get(genres[i]) + plays[i]);
            }
        }
        
        ArrayList<String> keySet = new ArrayList(genres_order.keySet());
        Collections.sort(keySet, (s1, s2) -> genres_order.get(s2) - genres_order.get(s1)); // 곡 순서 정렬
        
        for(String key : keySet){
            HashMap<Integer, Integer> map = plays_order.get(key);
            ArrayList<Integer> idxSet = new ArrayList(map.keySet());
            Collections.sort(idxSet, (s1, s2) -> map.get(s2) - map.get(s1)); // 재생 횟수 정렬
            
            answer.add(idxSet.get(0));
            if(idxSet.size() > 1){
                answer.add(idxSet.get(1));
            }
            
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}