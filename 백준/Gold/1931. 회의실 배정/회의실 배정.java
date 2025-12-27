import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static class Time implements Comparable<Time> {
        int start;
        int end;
    
        Time (int start, int end) {
            this.start = start;
            this.end = end;
        }
    
        @Override
        public int compareTo(Time other) {
            // 종료시간 먼저 비교
            if (this.end != other.end) return this.end - other.end;
            // 그 다음에 시작시간 비교
            else return this.start - other.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Time> times = new ArrayList<>();
        for (int i=0; i<N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            times.add(new Time(s, e));
        }

        // 정렬
        Collections.sort(times);

        // 비교
        int count = 0;
        int prevEndTime = 0;
        for (int i=0; i<N; i++) {
            if (times.get(i).start >= prevEndTime) {
                prevEndTime = times.get(i).end;
                count++;
            }
        }

        System.out.println(count);
    }
}