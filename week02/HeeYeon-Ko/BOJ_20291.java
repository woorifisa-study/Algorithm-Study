import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> extensions = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String[] str = bf.readLine().split("\\.");
            String extension = str[1]; // 확장자

            if(!hashMap.isEmpty() && hashMap.containsKey(extension)){
                Integer count = hashMap.get(extension);
                hashMap.put(extension, ++count);
            }
            else{
                hashMap.put(extension, 1);
                extensions.add(extension);
            }
        }

        Collections.sort(extensions);

        for (int i = 0; i < extensions.size(); i++) {
            String key = extensions.get(i);
            Integer num = hashMap.get(key);
            System.out.println(key + " " + num);
        }

    }
}
