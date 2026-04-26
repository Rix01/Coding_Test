import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        // 제일 큰 값 구하기
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(dp[i] > maxValue) {
                maxValue = dp[i];
            }
        }

        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();
    }
}
