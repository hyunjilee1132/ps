import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            int x = 0; // 나머지
            int i = 1; // 자릿수 

            while (true) {
                x = (x*10+1) % n; // 오버플로우 방지 
                if (x == 0) {
                    System.out.println(i);
                    break;
                }
                i++;
            }
        }
    }
}