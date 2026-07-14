import java.util.*;

class Solution {

    public int solution(String skill, String[] skill_trees) { 
    
        int answer = 0;
        
        for(String tree : skill_trees){
            int idx = 0;    
            boolean possible = true;
            
            for(char c : tree.toCharArray()){
            
                // 스킬트리에 없는 문자
                if(skill.indexOf(c) == -1){
                    continue;
                }
            
                // 불가능한 스킬트리
                if(c != skill.charAt(idx)){
                    possible = false;
                    break;
                }
                
                idx++;
            }
            
            if(possible) answer++;
                        
        }
        
        return answer;
    }
}

