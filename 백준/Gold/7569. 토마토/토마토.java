import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int H, N, M;
    static int[][][] box;
    static boolean[][][] discovered;
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static int totalZeroCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로
        H = sc.nextInt(); // 높이 

        discovered = new boolean[H][N][M]; 

        // 입력
        box = new int[H][N][M];
        for (int h=0; h<H; h++) {
            for (int y=0; y<N; y++) {
                for (int x=0; x<M; x++) {
                    box[h][y][x] = sc.nextInt();
                    
                    if (box[h][y][x] == 0) totalZeroCount++;
                    else if (box[h][y][x] == 1) {
                        queue.offer(new int[]{h, y, x});
                        discovered[h][y][x] = true;
                    }
                }
            }
        }

        if (totalZeroCount == 0) {
            System.out.println(0);
            return;
        }

        int result = bfs();

        if (totalZeroCount == 0) System.out.println(result);
        else System.out.println(-1);
    }

    static int bfs() {
        int count = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int s=0; s<size; s++) {
                int[] curr = queue.poll();
                int ch = curr[0];
                int cy = curr[1];
                int cx = curr[2];

                for (int i=0; i<6; i++) {
                    int nh = ch + dh[i];
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    // 범위 안에 있고, 아직 방문 안했고, 익지 않은 토마토가 있다면 
                    if (isValid(nh, ny, nx) && discovered[nh][ny][nx] == false && box[nh][ny][nx] == 0) {
                        queue.offer(new int[]{nh, ny, nx});
                        discovered[nh][ny][nx] = true;
                        totalZeroCount--;
                    }
                }
            }
        }

        return count;
    }

    static boolean isValid(int nh, int ny, int nx) {
        if (0<=nh && nh<H && 0<=ny && ny<N && 0<=nx && nx<M) return true;
        else return false;
    }
}