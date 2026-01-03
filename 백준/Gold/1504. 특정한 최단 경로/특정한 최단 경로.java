import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        long cost;

        public Node (int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost); 
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static long[] dist;
    static int N;
    static final long INF = 200000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int E = sc.nextInt();

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();

            graph.get(s).add(new Node(e, c));
            graph.get(e).add(new Node(s, c));
        }

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        long result1 = 0;
        result1 += dijkstra(1, p1);
        result1 += dijkstra(p1, p2);
        result1 += dijkstra(p2, N);

        long result2 = 0;
        result2 += dijkstra(1, p2);
        result2 += dijkstra(p2, p1);
        result2 += dijkstra(p1, N);

        long result = Math.min(result1, result2);

        if (result >= INF) System.out.println(-1);
        else System.out.println(result);
    }

    static long dijkstra(int start, int end) {
        dist = new long[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.to] < curr.cost) continue;

            for (Node next : graph.get(curr.to)) {
                long newCost = dist[curr.to] + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }

        return dist[end];
    }
}