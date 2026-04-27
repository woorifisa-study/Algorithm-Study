import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // int 배열 -> String 배열
        String[] str = new String[numbers.length];
        for(int i = 0; i<str.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        if(str[0].equals("0")){
            return "0";
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            answer.append(str[i]);
        }
        
        return answer.toString();
        
        
    }
}