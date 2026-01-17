package week02.jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 입력 받기
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");

            String extensionName = null;
            while (st.hasMoreTokens()) {
                extensionName = st.nextToken();
            }
            map.put(extensionName, map.getOrDefault(extensionName, 0) + 1);
        }

        // 정렬
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (String key: keys) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.println(sb);   
    }
}
