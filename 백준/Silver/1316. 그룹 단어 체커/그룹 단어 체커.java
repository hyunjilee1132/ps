import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        
        for (int i=0; i<n; i++) {
            if (check(sc.next())) count++;
        }

        System.out.println(count);
    }

    static boolean check(String str) {
        boolean[] checked = new boolean[26];
        int prev = 0; // 이전 아스키코드 값 

        for (int i=0; i<str.length(); i++) {
            int now = str.charAt(i); // 지금 아스키코드 값

            if (prev != now) { // 이전과 지금이 다르고
                if (!checked[now - 'a']) { // 체크하지 않았다면
                    checked[now - 'a'] = true; // true 처리하고 
                    prev = now; // 지금 원소는 직전꺼가 되어 다른거 또 비교
                } 
                else return false; // 체크했다면 false 처리
            }
        }

        return true;
    }
}