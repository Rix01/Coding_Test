import java.io.*;
import java.util.*;
public class Main
{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(numbers); // 오름차순 정렬

    int start = 0, end = 0, minValue = Integer.MAX_VALUE;

    while(end < n){

      int diff = numbers[end] - numbers[start];

      if(diff >= m) {
        minValue = Math.min(minValue, diff);
        start++;
      } else {
        end++;
      }

      // 같을 경우
      if(start==end) {
        end++;
      }
    }

    bw.write(minValue + "\n");
    bw.close();
  }
}