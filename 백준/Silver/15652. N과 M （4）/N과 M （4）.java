import java.io.*;
import java.util.Scanner;

class Main {
    static int n, m;
    static int[] arr, seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        seq = new int[m];

        int idx = 0;
        int start = 0;

        combination(idx, start);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void combination(int idx, int start) {
        if(idx == m) {
            for(int el : seq) {
                sb.append(el + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++) {
            seq[idx] = arr[i];
            combination(idx+1, i);
        }
    }
}