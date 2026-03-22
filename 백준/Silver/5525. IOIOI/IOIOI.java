import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray(); // 인덱스별 비교 위해 char[]로

        int answer = 0;
        int patternCount = 0;

        for(int i = 1; i < m - 1; i++) {
            if(s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I') {
                patternCount++;

                if(patternCount >= n) {
                    answer++;
                }

                i++;    // 여기에서 ++을 해줘서 2만큼 점프하게 하는 것
            }
            else {
                patternCount = 0;   // 0으로 초기화
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
