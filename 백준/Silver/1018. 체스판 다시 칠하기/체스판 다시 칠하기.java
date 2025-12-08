import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] inputArr = new char[n][m];
        for (int y=0; y<n; y++) {
            String line = sc.next();
            for (int x=0; x<m; x++) {
                inputArr[y][x] = line.charAt(x);
            }
        }

        String startW = "WBWBWBWB";
        String startB = "BWBWBWBW";

        int ans = Integer.MAX_VALUE;

        // 8x8 체스판
        for (int y=0; y<=n-8; y++) {
            for (int x=0; x<=m-8; x++) {
                int cntStartW = 0;
                int cntStartB = 0;

                for (int i=0; i<8; i++) {
                    String correctW = (i%2==0) ? startW : startB;
                    String correctB = (i%2==0) ? startB : startW;
                    for (int j=0; j<8; j++) {
                        if (inputArr[y+i][x+j] != correctW.charAt(j)) cntStartW++;
                        if (inputArr[y+i][x+j] != correctB.charAt(j)) cntStartB++;
                    }
                }

                ans = Math.min(ans, Math.min(cntStartW, cntStartB));
            }
        }

        System.out.println(ans);
    }
}
