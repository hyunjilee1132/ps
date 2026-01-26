import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int tc=0; tc<n; tc++) {
            int m = sc.nextInt();

            Map<String, Integer> map = new HashMap<>();
            for (int i=0; i<m; i++) {
                String s1 = sc.next();
                String s2 = sc.next();

                map.put(s2, map.getOrDefault(s2, 0) + 1);
            }

            int result = 1;
            for (int count : map.values()) {
                result *= (count+1);
            }

            // 전체 다 안입은 경우
            result -= 1;

            System.out.println(result);
        }
    }
}