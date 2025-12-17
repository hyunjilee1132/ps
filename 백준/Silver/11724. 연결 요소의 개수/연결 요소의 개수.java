import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] discovered;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList<>();

        // 초기화
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        // 입력 
        for (int i=0; i<M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        discovered = new boolean[N+1];

        count = 0;
        for (int i=1; i<=N; i++) {
            if (!discovered[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        discovered[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : graph.get(currentNode)) {
                if (!discovered[nextNode]) {
                    discovered[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
    }
}