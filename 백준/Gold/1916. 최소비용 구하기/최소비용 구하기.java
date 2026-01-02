import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;
    
        public Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();

            graph.get(s).add(new Node(e, w));
        }

        int s = sc.nextInt();
        int e = sc.nextInt();
        int result = dijkstra(s, e);

        System.out.println(result);
    }

    static int dijkstra(int start, int end) {
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currPlace = curr.to;
            int currWeight = curr.weight;

            if (dist[currPlace] < currWeight) continue; // 이미 더 짧은 경로로 방문했다면 무시하기 

            for (Node next : graph.get(currPlace)) {
                int newWeight = dist[currPlace] + next.weight; // 현재까지의 비용 + 다음 장소까지의 비용

                if (newWeight < dist[next.to]) { // 방금 계산한 비용과 기존에 계산해놨던 비용 비교 
                    dist[next.to] = newWeight; // 최저가면 갱신 
                    pq.add(new Node(next.to, newWeight));
                }
            }
        }

        return dist[end];
    }
}