import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long[] t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        t = new long[n+1];

        bw.write(String.valueOf(calculate(n)));
        bw.flush();
        bw.close();
    }

    public static long calculate(int n) {
        if(n==0 || n==1) {
            return 1;
        }

        t[0] = 1;
        t[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                t[i] += t[j] * t [i-1-j];
            }
        }

        return t[n];
    }
}
