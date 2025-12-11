import java.util.*;

public class Main {
    static boolean[][] discovered;
    static int[][] board; // 배추 밭 

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc=0; tc<t; tc++) {
            M = sc.nextInt(); // 가로
            N = sc.nextInt(); // 세로
            int K = sc.nextInt(); // 배추 개수

            // 초기화
            discovered = new boolean[N][M];
            board = new int[N][M];

            // 입력
            for (int i=0; i<K; i++) {
                int X = sc.nextInt(); // 가로
                int Y = sc.nextInt(); // 세로

                board[Y][X] = 1; // 배추가 있으면 1
            }

            int cnt = 0;
            for (int y=0; y<N; y++) {
                for (int x=0; x<M; x++) {
                    if (board[y][x] == 1 && !discovered[y][x]) {
                        bfs(y, x);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        discovered[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];

            // 사방 탐색하면서 델타 이동 
            for (int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (isValid(ny, nx)) { // 범위가 유효하고
                    if (board[ny][nx] == 1 && !discovered[ny][nx]) { // 배추가 있고, 아직 방문하지 않았다면
                        queue.offer(new int[]{ny, nx});
                        discovered[ny][nx] = true;
                    }
                }
            }
        }
    }

    // 경계 체크 
    public static boolean isValid(int ny, int nx) {
        if (0<=ny && ny<N && 0<=nx && nx<M) return true;
        else return false;
    }
}