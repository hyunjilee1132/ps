import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M, N;
    static int[][] box;
    static boolean[][] discovered;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static int totalZeroCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로

        discovered = new boolean[N][M];

        // 입력
        box = new int[N][M];
        for (int y=0; y<N; y++) {
            for (int x=0; x<M; x++) {
                box[y][x] = sc.nextInt();
                if (box[y][x] == 0) totalZeroCount++;
                else if (box[y][x] == 1) {
                    queue.offer(new int[]{y,x});
                        discovered[y][x] = true;
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
                int cy = curr[0];
                int cx = curr[1];

                for (int i=0; i<4; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    // 범위 안에 있고, 아직 방문 안했고, 익지 않은 토마토가 있다면 
                    if (isValid(ny, nx) && discovered[ny][nx] == false && box[ny][nx] == 0) {
                        queue.offer(new int[]{ny, nx});
                        discovered[ny][nx] = true;
                        // box[ny][nx] = 1;
                        totalZeroCount--;
                    }
                }
            }
        }

        return count;
    }

    static boolean isValid(int ny, int nx) {
        if (0<=ny && ny<N && 0<=nx && nx<M) return true;
        else return false;
    }
}