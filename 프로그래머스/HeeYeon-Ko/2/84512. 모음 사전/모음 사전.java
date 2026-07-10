import java.util.*;
class Solution {
    
    static List<String> list = new ArrayList<>(); //만들어지는 모든 단어 저장
    static String[] words = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0; 
        
        dfs("");
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        return answer;
        
    }
    
    public void dfs(String word){
        // 자기 자신 list에 추가
        list.add(word); 
        
        // 5글자면 종료 
        if(word.length() == 5){
            return;
        }
        
        // 5글자 아닌 경우
        for(int i = 0; i<5; i++){
            dfs(word + words[i]);
        }
        
    }
    
}