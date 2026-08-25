class Solution {
    static int count = 0;
    public int solution(int n, int[][] computers) {
        // dfs 활용, 1이면 연결된 노드, 0이면 미연결된 노드
        boolean[] isVisited = new boolean[n]; // 방문 여부
        
        for(int i=0; i<n; i++) {
            if(!isVisited[i]) { // 미방문 시
                count++;        // 카운트 추가
                dfs(computers, isVisited, i);
            }
        }
        return count;
    }
    
    public void dfs(int[][] computers, boolean[] isVisited, int current) {
        // i는 현재 노드인 current
        isVisited[current] = true;
        
        for(int i=0; i<computers.length; i++) {
            if(computers[current][i] ==1 && !isVisited[i]) {
                dfs(computers, isVisited, i);
            }
        }
    }
}