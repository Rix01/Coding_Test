import java.io.*;
import java.util.*;

public class Main {
    public static int R, C, W;
    public static int[][] triangle = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        // 삼각형 만들어놓기
        triangle[0][0] = 1;
        triangle[1][0] = 1;
        triangle[1][1] = 1;

        for(int i = 2; i < 30; i++) {
            // 처음과 끝은 1
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for(int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }

        // R, C, W에 따라
        int sum = 0;
        for(int i = 0; i < W; i++) {
            for(int j = 0; j < i+1; j++) {
                sum += triangle[R-1+i][C-1+j];
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
