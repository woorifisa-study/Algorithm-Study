import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int answer = 0;        
        int conveyer_belt = 1;
        
        // 보조 컨테이너 벨트 stack
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < order.length; i++) {
            
            // 메인 컨베이어 벨트에서 꺼낼 수 있는 경우
            if (order[i] == conveyer_belt) {
                conveyer_belt++;
                answer++;
            }
            
            // 스택 맨 위에서 꺼낼 수 있는 경우
            else if (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
            }
            
            // 메인 컨테이너 벨트 -> stack 옮기는 경우
            else if (order[i] > conveyer_belt) {
                while (conveyer_belt < order[i]) {
                    stack.push(conveyer_belt++);
                }
                conveyer_belt++;
                answer++;
            }            
                        
            // 그 외
            else break;
        }
        
        return answer;
    }
}