class Solution {
    private int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        int[] candidate = new int[5];
        combination(1,0,n, candidate, q, ans);
        return answer;
    }
    
    // 조합 메서드
    private void combination(
        int start, int depth, int n,
        int[] candidate, int[][] q, int[] ans) {
        // 숫자 5개 모두 선택
        if(depth ==5) {
            if(isPossible(candidate, q, ans)) answer++;
            return;
        }
        
        // 현재 위치에 들어갈 숫자 선택하기
        for(int num=start; num<=n; num++) {
            candidate[depth] = num;
            combination(num+1, depth+1, n, candidate, q, ans);
        }
    }
    
    private boolean isPossible(int[] candidate, int[][] q, int[] ans) {
        for(int i=0; i<q.length; i++) {
            // 모든 시도 검사하기
            int cnt=0;
            
            //q[i]의 숫자 5개 확인하기
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(q[i][j] == candidate[k]) {
                        cnt++; break;
                    }
                }
            }
            
            // 하나라도 다르면 탈락
            if(cnt !=ans[i]) return false;
        }
        return true;
    }
    
}