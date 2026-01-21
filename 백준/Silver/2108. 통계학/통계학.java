import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        // 산술평균
        System.out.println(Math.round((double) sum/n));

        // 중앙값 
        System.out.println(arr[n/2]);

        // 최빈값
        int maxFreq = 0;
        int currFreq = 0;

        for (int i=0; i<n; i++) {
            if (i>0 && arr[i] == arr[i-1]) currFreq++;
            else currFreq = 1;

            if (currFreq > maxFreq) maxFreq = currFreq;
        }

        int mode = 0;
        int cnt = 0;
        for (int i=0; i<n; i++) {
            int start = i;
            while (i+1 < n && arr[i] == arr[i+1]) i++;

            int freq = i - start + 1; // 빈도수

            if (freq == maxFreq) {
                mode = arr[start];
                cnt++;

                if (cnt == 2) break; // 두번째 최빈값
            }
        }
        System.out.println(mode);

        // 범위
        System.out.println(arr[n-1] - arr[0]);

    }
}