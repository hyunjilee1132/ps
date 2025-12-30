import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static char[][] grid;
    static char[][] rgGrid;
    static boolean[][] discovered;
    static boolean[][] rgDiscovered;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int count = 0;
    static int rgCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 입력 
        grid = new char[N][N];
        rgGrid = new char[N][N];
        for (int y=0; y<N; y++) {
            String str = sc.next();
            for (int x=0; x<N; x++) {
                char c = str.charAt(x);
                // grid에는 들어오는대로 넣고
                grid[y][x] = c;
                // rgGrid에는 들어오는게 G면 R이라고 넣고, 나머지는 들어오는대로 넣기
                if (c == 'G') rgGrid[y][x] = 'R';
                else rgGrid[y][x] = c;
            }
        }

        discovered = new boolean[N][N];
        rgDiscovered = new boolean[N][N];
        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                if (!discovered[y][x]) {
                    bfs(y, x);
                    count++;
                }
                if (!rgDiscovered[y][x]) {
                    rgBfs(y, x);
                    rgCount++;
                }
            }
        }

        System.out.println(count + " " + rgCount);
    }

    
    static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        discovered[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cy = curr[0];
            int cx = curr[1];

            for (int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (isValid(ny, nx) && !discovered[ny][nx] && grid[cy][cx] == grid[ny][nx]) {
                    discovered[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    static void rgBfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        rgDiscovered[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cy = curr[0];
            int cx = curr[1];

            for (int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (isValid(ny, nx) && !rgDiscovered[ny][nx] && rgGrid[cy][cx] == rgGrid[ny][nx]) {
                    rgDiscovered[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    static boolean isValid(int ny, int nx) {
        if (0<=ny && ny<N && 0<=nx && nx<N) return true;
        else return false;
    }
}