import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // String으로 변환
        String[] strnum = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            strnum[i] = Integer.toString(numbers[i]);
        }
        
        // 문자열 비교 (Arrays.sort(numbers) 불가능)
        Arrays.sort(strnum, (a,b) -> {
            return (b+a).compareTo(a+b); // 큰 값을 앞에 배치
        });
        
        // 문자열 합치기
        String answer="";
        for(int i=0; i<strnum.length; i++) {
            answer +=strnum[i];
        }
        
        // 첫자리수가 0일 때
        if(strnum[0].equals("0")) return "0";
        
        return answer;
    }
}