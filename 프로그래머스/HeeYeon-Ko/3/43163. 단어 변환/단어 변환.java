class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE; 
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        if(answer == Integer.MAX_VALUE){
            return 0;
        }
        
        return answer;
    }
    
    int numOfDiff(String from, String to){
        int count = 0; 
        char[] from_ch = from.toCharArray();
        char[] to_ch = to.toCharArray();
        for(int i = 0; i < from.length(); i++){
            if(from_ch[i] != to_ch[i]) count++;
        }
        return count;
    }
    
    void dfs(String begin, String target, String[] words, int count){
        if(begin.equals(target)){
            answer = Math.min(answer, count);
            return; 
        }
        
        for(int i = 0; i < words.length; i++){
            if(!visited[i] && numOfDiff(begin, words[i]) == 1){
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false; 
            }
        }
    }
}