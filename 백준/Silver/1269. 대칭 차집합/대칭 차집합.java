import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aCnt = Integer.parseInt(st.nextToken());
        int bCnt = Integer.parseInt(st.nextToken());

        // A
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<aCnt; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // B
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<bCnt; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 두 집합 원소 비교 하는데 A에 있으면 제거하고, 없으면 넣고 - size 계산 
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }

        System.out.println(set.size());
    }
}