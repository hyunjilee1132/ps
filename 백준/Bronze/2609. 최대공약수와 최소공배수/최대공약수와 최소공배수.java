import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int GCD = findGCD(a, b);
        int LCM = GCD * (a/GCD) * (b/GCD);

        System.out.println(GCD);
        System.out.println(LCM);
    }

    static int findGCD(int a, int b) {
        int S = Math.min(a, b);
        int B = Math.max(a, b);
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=S; i++) {
            if (S%i==0) {
                list.add(i);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        int GCD = 0;
        for (int i=0; i<list.size(); i++) {
            if (B%list.get(i)==0) {
                return list.get(i);
            }
        }
        return 0;
    }
}