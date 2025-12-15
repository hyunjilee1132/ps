import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited; // dfs
    static StringBuilder sb = new StringBuilder(); // 결과 출력용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        // 입력 
        for (int i=0; i<M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            // 무방향
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        // 조건: 정점 번호가 작은 것 먼저 방문
        for (int i=1; i<=N; i++) {
            Collections.sort(graph.get(i)); // 정점 i에 연결된 인접리스트
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        bfs(V, N);

        System.out.println(sb.toString());
    }

    static void dfs(int startNode) {
        visited[startNode] = true;
        sb.append(startNode).append(" ");

        for (int nextNode : graph.get(startNode)) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    static void bfs(int startNode, int N) {
        boolean[] discovered = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        discovered[startNode] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            sb.append(currentNode).append(" ");

            for (int nextNode : graph.get(currentNode)) {
                if (!discovered[nextNode]) {
                    discovered[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
    }
}