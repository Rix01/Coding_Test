import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        // Pn부터 만들기
        StringBuilder sb = new StringBuilder("IOI");
        for(int i = 0; i < n-1; i++) {
            sb.append("OI");
        }

        // Pn의 길이
        int pnLen = sb.length();
        int count = 0;
        for(int i = 0; i < s.length() - pnLen + 1; i++) {
            if(s.substring(i, i+pnLen).equals(sb.toString())) {
                count += 1;
            }
        }

        bw.write(String.valueOf(count));
        bw.close();
    }
}
