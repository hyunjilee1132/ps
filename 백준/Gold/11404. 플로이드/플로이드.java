import java.util.*;

public class Main {
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE / 2; // overflow 때문에 /2 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dist = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            dist[s][e] = Math.min(dist[s][e], c);
        }

        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (dist[i][j] != INF) System.out.print (dist[i][j] + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
    }
}