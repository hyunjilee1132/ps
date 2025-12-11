import java.util.*;

public class Main {
    static boolean[] discovered;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 컴퓨터의 수
        int E = sc.nextInt(); // 네트워크 수

        // 그래프 초기화
        for (int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        discovered = new boolean[V+1];

        // 그래프 연결(무방향)
        for (int i=0; i<E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        bfs(1);

        int cnt = 0;
        for (int i=1; i<=V; i++) {
            if (discovered[i]) cnt++;
        }

        System.out.println(cnt-1); // 1번 컴퓨터 제외
    }

    public static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startNode);
        discovered[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : graph.get(currentNode)) {
                if (!discovered[nextNode]) {
                    queue.offer(nextNode);
                    discovered[nextNode] = true;
                }
            }
        }
    }
}