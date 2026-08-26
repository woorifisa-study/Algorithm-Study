import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // words 에 target 없으면 return 0
        boolean targetExists = false;
        for(String word : words){
            if(word.equals(target)){
                targetExists = true;
                break;
            } 
        }
        if(!targetExists) return 0;
        
        
        int n = words.length;
        
        // 그래프 만들기
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        // 노드 구성
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && isOneCharDiff(words[i], words[j])){
                    graph.get(i).add(j);
                }
            }
        }

        // bfs 탐색
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        
        // word에는 begin이 없음. begin부터 연결될 요소들 골라서 큐에 삽입
        for(int i = 0; i < n; i++){
            if(isOneCharDiff(begin, words[i])){
                queue.offerLast(i);  
                visited[i] = true;
            } 
        }
        
        int depth = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int cur = queue.pollFirst();
                if(words[cur].equals(target)) return depth;
                
                for(int next : graph.get(cur)){
                    if(!visited[next]){
                        queue.offerLast(next);  
                        visited[next] = true;
                    } 
                }
            }
            
            depth++;
        }
        
        return 0;
    }
    
    // 한글자만 다른 단어인지 확인
    private boolean isOneCharDiff(String word1, String word2){
        int diff = 0;
        
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        
        return true;
    }
}