import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int pSum = list.get(0);
        int ans = list.get(0);
        for (int i=1; i<n; i++) {
            pSum += list.get(i);
            ans += pSum;
        }

        System.out.println(ans);
    }
}