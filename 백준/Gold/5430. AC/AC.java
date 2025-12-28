import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc=0; tc<T; tc++) {
            String p = sc.next(); 
            int n = sc.nextInt(); 
            String input = sc.next();

            Deque<String> deque = new ArrayDeque<>();
            if (n > 0) { // 0<=n
                String[] parseInput = input.replace("[", "").replace("]", "").split(",");
                for (int i=0; i<n; i++) {
                    deque.add(parseInput[i]); // 알맹이만 넣기 
                }
            }

            boolean isReverse = false; // 매번 descending하면 시간초과 - boolean으로 상태관리 
            boolean isError = false;
            for (int i=0; i<p.length(); i++) {
                if (p.charAt(i) == 'R') isReverse = !isReverse; // 뒤집은 상태 갱신 
                else { // D
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } 
                    else {
                        if (isReverse) deque.pollLast();
                        else deque.pollFirst();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if (isError) System.out.println("error");
            else {
                if (isReverse) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                } 
                else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                }
                System.out.println("[" + sb + "]");
            }
        }
    }
}