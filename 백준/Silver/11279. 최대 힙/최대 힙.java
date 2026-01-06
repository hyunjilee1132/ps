import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙 
        for (int i=0; i<N; i++) {
            int x = sc.nextInt();
            if (x > 0) pq.add(x);
            else if (x == 0) {
                if (pq.size() > 0) System.out.println(pq.poll());
                else System.out.println(0);
            }
        }
    }
}