import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            // 맨앞 버리고 - 그 다음꺼 맨 뒤로 보내기 반복
            queue.poll();
            queue.offer(queue.peek());
            queue.poll();
        } 

        System.out.println(queue.peek());
    } 
}