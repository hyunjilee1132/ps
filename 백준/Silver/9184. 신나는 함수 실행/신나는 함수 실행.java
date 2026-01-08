import java.util.Scanner;

public class Main {
    static int[][][] arr = new int[21][21][21]; // 0~20: 0으로 초기화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a==-1 && b==-1 && c==-1) return;

            int result = w(a, b, c);
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
        }
    }

    static int w(int a, int b, int c) {
        // 범위 넘어가면
        if (a<=0 || b<=0 || c<=0) return 1;
        if (a>20 || b>20 || c>20) return w(20, 20, 20);

        // 나왔던거면 저장한것중에 찾아서 반환
        if (arr[a][b][c] != 0) return arr[a][b][c];

        // 없으면 배열에 저장하고 반환
        if (a<b && b<c) {
            arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        else {
            arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }

        return arr[a][b][c];
    }
}