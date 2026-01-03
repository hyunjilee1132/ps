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
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점 개수
        int E = sc.nextInt(); // 간선 개수
        int K = sc.nextInt(); // 시작 정점 번호 

        for (int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt(); 
            int w = sc.nextInt();

            graph.get(s).add(new Node(e, w));
        }

        dijkstra(K, V);

        for (int i=1; i<=V; i++) {
            if (dist[i] != INF) System.out.println(dist[i]);
            else System.out.println("INF");
        }
    }

    static void dijkstra(int start, int v) {
        dist = new int[v+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.to] < curr.weight) continue;

            for (Node next : graph.get(curr.to)) {
                int newWeight = dist[curr.to] + next.weight;
                if (newWeight < dist[next.to]) {
                    dist[next.to] = newWeight;
                    pq.add(new Node(next.to, newWeight));
                }
            }
        }
    }
}