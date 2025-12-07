import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i=1; i<k; i++) {
                int frontOut = queue.poll();
                queue.add(frontOut);
            }
            int ans = queue.poll();
            list.add(ans);
        }

        System.out.print("<");
        for (int i=0; i<n-1; i++) {
            System.out.print(list.get(i)+", ");
        }
        System.out.print(list.get(list.size()-1) + ">");
    }
}