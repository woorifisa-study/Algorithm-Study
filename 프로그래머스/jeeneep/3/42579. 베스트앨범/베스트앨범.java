import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        int len = genres.length;
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<Music>> musicMap = new HashMap<>(); 
        for (int i = 0; i < len; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            
            Music music = new Music(i, plays[i]);
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(music);
        }
        
        // genreMap 총 재생 횟수 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(genreMap.entrySet());
        sortedGenres.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));                                   
        List<Integer> result = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : sortedGenres) {
            
            String genre = entry.getKey();            
            List<Music> musicList = musicMap.get(genre);
            
            // musicList 재생 횟수 내림차순, 고유번호 오름차순 정렬
            musicList.sort((o1, o2) -> {
                if (o1.play != o2.play) {
                    return Integer.compare(o2.play, o1.play); 
                }
                return Integer.compare(o1.index, o2.index);
            });  
            
            for (int i = 0; i < Math.min(musicList.size(), 2); i++) {
                result.add(musicList.get(i).index);
            }
        }
                        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    class Music {
        int index;
        int play;
        
        Music(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}