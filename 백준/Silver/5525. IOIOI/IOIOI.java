import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); // 주어진 문자열의 길이
        String str = sc.next(); // 주어진 문자열 

        int count = 0;

        StringBuilder ioi = new StringBuilder("I");
        for (int i=0; i<n; i++) {
            ioi.append("OI");
        }

        String strioi = new String(ioi); // sb -> string
        
        int len = strioi.length();
        for (int i=0; i<=m-len; i++) {
            if (str.substring(i, i+len).equals(strioi)) count++; 
        }

        System.out.println(count);
    }
}

// 비교할 문자열은 IOI에 for문 돌면서 OI 붙이고,
// 그 값으로 주어지는 문자열에 슬라이딩 윈도우로 범위를 좁힌 뒤, equal한지 비교하기, 같으면 cnt++