import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][10];

        // dp[0][0] ~ dp[0][9]까지는 1
        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < N+1; i++) {
            dp[i][0] = Arrays.stream(dp[i-1]).sum() % 10007; // 이전 행 다 더하기
            for(int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j-1] - dp[i-1][j-1] + 10007) % 10007;
            }
        }
        int answer = dp[N][0];
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
