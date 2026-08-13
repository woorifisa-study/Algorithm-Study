import java.util.*;
class Solution {
    
    // 상하좌우 이동
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        // storage: 컨테이너 정보, requests: 종류(알파벳) 및 출고방법
        int n = storage.length;
        int m = storage[0].length();
        
        // 외부 공간
        char[][] map = new char[n+2][m+2];
        
        // 초기 값 채우기(.)
        for(int i=0; i<n+2; i++) {
            Arrays.fill(map[i], '.');
        }
        
        // 참고 데이터 입력하기
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }

        // 출고 요청을 처리
        for(String request: requests) {
            char target = request.charAt(0);
            
	        if(request.length() == 2) {
                // 크레인 처리
                crane(map, target);
                
        	} else {
                // bfs 실행
                forklift(map, target);
            }
        }
        
        // 남은 컨테이너 개수 계산하기
        int count = 0;        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(map[i][j] != '.') count++;
            }
        }
        
        return count;
    }
    
    // 크레인(알파벳) 출고
    private void crane(char[][] map, char target) {
        
        for(int i=1; i< map.length-1; i++) {
            for(int j=1; j < map[0].length-1; j++) {
                
                // 값이 일치하면 외부 연결 컨테이너로 변경
                if(map[i][j] == target) map[i][j] = '.';
            }
        }   
    }
    
    // 지게차 출고
    private void forklift(char[][] map, char target) {
        
        int n = map.length;
        int m = map[0].length;
        
        Queue<int[]> queue = new LinkedList<>(); // 좌표 저장소
        boolean[][] visited = new boolean[n][m]; // 방문 여부 저장소
        List<int[]> remove = new ArrayList<>(); // 제거 대상 컨테이너
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        // BFS 탐색 진행
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int d=0; d<4; d++) { // 상하좌우 탐색
                int nr = cur[0] + dr[d]; // 상하
                int nc = cur[1] + dc[d]; // 좌우

                // map 범위를 벗어나면 continue
                if(nr <0 || nr>=n // 상하 범위 
                    || nc<0 || nc>=m) // 좌우 범위
                    continue;
                
                // 이미 방문했으면 continue
                if(visited[nr][nc]) continue;
                
                // 외부 빈 공간 탐색하기
                if(map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc}); // 빈 공간이면 큐에 추가(offer란: 큐에 요소를 추가하는 메서드)
                }
                
                // 출고 대상 저장하기
                else if(map[nr][nc] == target) {
                    visited[nr][nc] = true;
                    remove.add(new int[]{nr, nc}); // add란: 리스트에 요소를 추가하는 메서드
                }
            }
        }
        
        // 컨테이너 제거
        for(int[] pos: remove) 
            map[pos[0]][pos[1]] = '.';
    }
}