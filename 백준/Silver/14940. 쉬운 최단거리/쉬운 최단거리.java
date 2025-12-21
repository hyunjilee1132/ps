import java.util.*;

public class Main {
    static int n, m;
    static int[][] map; // 입력 저장
    static int[][] dist; // 거리 저장
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        dist = new int[n][m];

        int startY = -1, startX = -1;

        for (int y=0; y<n; y++) {
            for (int x=0; x<m; x++) {
                map[y][x] = sc.nextInt();
                dist[y][x] = -1; // 거리는 모두 -1로 초기화 

                if (map[y][x] == 2) { // 시작점
                    startY = y;
                    startX = x;
                    dist[y][x] = 0;
                } else if (map[y][x] == 0) { // 원래 못가는 지점 
                    dist[y][x] = 0;
                }
            }
        }

        bfs(startY, startX);

        for (int y=0; y<n; y++) {
            for (int x=0; x<m; x++) {
                System.out.print(dist[y][x] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cy = curr[0];
            int cx = curr[1];

            for (int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                // 범위 안에 있고, 방문 안했는데(-1), 갈 수 있는 경로면 - dist에 현재 경로에 1 더하기
                if (isValid(ny, nx) && dist[ny][nx] == -1 && map[ny][nx] == 1) {
                    dist[ny][nx] = dist[cy][cx] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    static boolean isValid(int ny, int nx) {
        if (0<=ny && ny<n && 0<=nx && nx<m) return true;
        else return false;
    }
}