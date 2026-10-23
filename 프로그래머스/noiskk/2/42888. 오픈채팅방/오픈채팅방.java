import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();
        
        for(String cur : record){
            String[] order = cur.split(" ");
            if(order[0].equals("Leave")) continue;
            map.put(order[1], order[2]);
        }
        
        List<String> answerList = new ArrayList<>();
        
        for(String cur : record){
            String[] order = cur.split(" ");
            
            if(order[0].equals("Change")) continue;
            
            StringBuilder sb = new StringBuilder();
            
            if(order[0].equals("Enter")){
                sb.append(map.get(order[1])).append("님이 들어왔습니다.");
            } else if(order[0].equals("Leave")){
                sb.append(map.get(order[1])).append("님이 나갔습니다.");
            }
            
            answerList.add(sb.toString());
        }
        
        String[] answer = new String[answerList.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}