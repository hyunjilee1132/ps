import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                int newValue = map.get(key) + 1;
                map.put(key, newValue);
            } else {
                map.put(key, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> ansList = new ArrayList<>();
        for (int i=0; i<m; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                ansList.add(map.get(key));
            } else {
                ansList.add(0);
            }
        }

        for (int el : ansList) {
            bw.write(String.valueOf(el));
            bw.write(" ");
        }

        bw.flush(); 
        bw.close();
        br.close();
    } 
}