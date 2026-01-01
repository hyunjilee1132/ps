import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Node implements Comparable<Node> {
        long num; 
        int idx;

        public Node(long num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.num, other.num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc=0; tc<T; tc++) {
            PriorityQueue<Node> minHeap = new PriorityQueue<>(); // 최소힙 
            PriorityQueue<Node> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙 
            
            int k = sc.nextInt();
            boolean[] visited = new boolean[k];

            for (int i=0; i<k; i++) {
                String op = sc.next();
                long n = sc.nextLong();

                if (op.equals("I")) {
                    minHeap.add(new Node(n, i));
                    maxHeap.add(new Node(n, i));
                    visited[i] = true;
                } 
                else { // op == 'D'
                    if (n == 1) {
                        while (!maxHeap.isEmpty() && !visited[maxHeap.peek().idx]) {
                            maxHeap.poll();                            
                        }
                        if (!maxHeap.isEmpty()) {
                            visited[maxHeap.poll().idx] = false; // 삭제 체크
                        }
                    } 
                    else {
                        while (!minHeap.isEmpty() && !visited[minHeap.peek().idx]) {
                            minHeap.poll();                            
                        }
                        if (!minHeap.isEmpty()) {
                            visited[minHeap.poll().idx] = false; // 삭제 체크
                        }
                    }
                }
            }

            while (!maxHeap.isEmpty() && !visited[maxHeap.peek().idx]) {
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && !visited[minHeap.peek().idx]) {
                minHeap.poll();
            }

            if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxHeap.peek().num + " " + minHeap.peek().num);
            }        
        }
    }
}