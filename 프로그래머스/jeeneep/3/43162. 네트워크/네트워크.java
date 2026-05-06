class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            // i번 컴퓨터를 방문하지 않았다면 검사
            if (!visited[i]) {
                answer++;
                dfs(i, n, computers, visited);
            }             
        }
        return answer;
    }
    
    public void dfs(int i, int n, int[][] computers, boolean[] visited) {
        // 방문 표시
        visited[i] = true;
        
        // i번째 컴퓨터와 연결된 컴퓨터들 검사
        for (int j = 0; j < n; j++) {
            if (i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(j, n, computers, visited);
            }
        }
    }
}