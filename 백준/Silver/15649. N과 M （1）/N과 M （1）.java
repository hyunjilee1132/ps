import java.util.*;

class Main {
    static int n, m;
    static int[] arr;
    static int[] seq;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        seq = new int[m];
        visited = new boolean[n];

        int idx = 0;

        permutation(idx);
    }

    static void permutation(int idx) {
        if(idx == m) {
            for(int el : seq) {
                System.out.print(el + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                seq[idx] = arr[i];
                permutation(idx+1);
                visited[i] = false;
            }
        }

    }
}