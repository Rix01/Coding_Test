import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    int start = 0, end = 0;
    int hap = 0, count = 0;

    while (end < n) {
      hap +=  numbers[end];
      while (hap >= m) {
        if(hap == m) count++;
        hap -= numbers[start];
        start++;
      }
      end++;
    }
    bw.write(String.valueOf(count) + "\n");
    bw.close();
  }
}