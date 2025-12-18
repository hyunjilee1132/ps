import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] time = new int[100001]; // 방문체크(미방문시 0), 시간기록 
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        bfs(N);

        System.out.println(time[K]-1); // bfs 함수에서 시작부터 1을 올리고 시작 -> 1 빼고 출력 
    }

    static int bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        time[startNode] = 1; 

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == K) break; 
            
            int[] nextNodes = {currentNode-1, currentNode+1, currentNode*2};
            for (int nextNode : nextNodes) {
                if (0<=nextNode && nextNode<=100000 && time[nextNode]==0) {
                    time[nextNode] = time[currentNode]+1;
                    queue.offer(nextNode);
                }
            }
        }

        return time[startNode];
    }
}