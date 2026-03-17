import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static String[] callArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
             callArr = new String[n];
            for(int j = 0; j < n; j++) {
                callArr[j] = br.readLine();
            }

            // String[] 사전식 정렬
            Arrays.sort(callArr);

            String result = check(callArr);
            System.out.println(result);
        }

    }

    public static String check(String[] callArr) {
        for(int i = 0; i < callArr.length - 1; i++) {
            if(callArr[i+1].startsWith(callArr[i])) return "NO";
        }
        return "YES";
    }
}
