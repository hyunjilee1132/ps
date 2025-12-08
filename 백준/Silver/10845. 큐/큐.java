import java.util.*;

public class Main {
    public static final int NUMBER_OF_PUSH = 5; // "push "

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Deque<String> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            String input = sc.nextLine();

            if (input.startsWith("push")) {
                queue.add(input.substring(NUMBER_OF_PUSH));
            }
            else if (input.equals("pop")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println("-1");
                }
            }
            else if (input.equals("size")) {
                System.out.println(queue.size());
            }
            else if (input.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
            else if (input.equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.getFirst());
                } else {
                    System.out.println("-1");
                }
            }
            else {
                if (!queue.isEmpty()) {
                    System.out.println(queue.getLast());
                } else {
                    System.out.println("-1");
                }
            }
        }
    }

    private static class NUMBER_OF_PUSH {

        public NUMBER_OF_PUSH() {
        }
    }
}