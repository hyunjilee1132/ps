import java.util.*;

public class Main {
    static List<List<Integer>> G = new ArrayList<>();
    static boolean[] visited;
    static int[][] result;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        result = new int[N][N];
        
        for (int i=0; i<N; i++) {
            G.add(new ArrayList<>());
        }

        // 2차원 배열을 인접 리스트로 변환 
        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                if (sc.nextInt() == 1) G.get(y).add(x);
            }
        }

        // 각 노드에서 끝까지 탐색
        for (int i=0; i<N; i++) {
            visited = new boolean[N];
            dfs(i, i); // 고정, 변동 
        }

        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                System.out.print(result[y][x] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int start, int curr) {
        for (int next : G.get(curr)) {
            if (!visited[next]) {
                visited[next] = true;
                result[start][next] = 1;
                dfs(start, next); // 다음 노드로 더 들어가기 
            }
        }
    }
}