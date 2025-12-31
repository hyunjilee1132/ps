import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] bound = new int[101];
    static int[] dist = new int[101];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 초기화
        for (int i=0; i<101; i++) {
            bound[i] = i;
        }

        // 사다리, 뱀 삽입 
        for (int i=0; i<N+M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            bound[s] = e;
        }

        int result = bfs(1); // 1에서 100까지 가는 최단경로 

        System.out.println(result);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        // 거리 초기화 
        for (int i=0; i<101; i++) {
            dist[i] = -1;
        }

        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == 100) return dist[curr]; // 지금 도착하면 반환 

            // 주사위 눈 개수만큼 돌리면서 확인 
            for (int i=1; i<=6; i++) {
                int tmpDest = curr + i; // 주사위 굴렸을때 나오는 칸 

                if (tmpDest <= 100) {
                    int realDest = bound[tmpDest]; // 뱀이나 사다리 타고 갔을때의 진짜 도착지 - 한번 거쳐서 계산!

                    if (dist[realDest] == -1) {
                        dist[realDest] = dist[curr] + 1;
                        queue.offer(realDest); // 다음은 타고 흘러간 진짜 위치에서 시작 
                    }
                }
            }
        }

        return 0;
    }
}