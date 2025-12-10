import java.io.*;
import java.util.*;

public class Main {
  static int t;
  static int n;
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    t = Integer.parseInt(br.readLine());
    for(int i = 0; i < t; i++) {
      n = Integer.parseInt(br.readLine());
      int midIndex = n / 2;
      int[] orders = new int[n];

      numbers = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        numbers[j] = Integer.parseInt(st.nextToken());
      }
      // 정렬
      Arrays.sort(numbers);

      // 맨 뒤에 값은 midIndex에
      orders[midIndex] = numbers[n-1];

      // 뒤에서부터 돌면서 orders 채움
      int fromMidIndex = 1;
      for(int j = n-2; j >=0; j-=2) {
        orders[(midIndex + fromMidIndex)%n] = numbers[j];
        if(j-1 >=0) {
          orders[midIndex - fromMidIndex] = numbers[j - 1];
        }
        fromMidIndex++;
      }

      // 차이값 제일 큰 거 구하기
      int result = findMaxDiff(orders);
      bw.write(result + "\n");
    }
    bw.close();
  }

  private static int findMaxDiff(int[] orders) {
    int maxDiff = 0;
    for(int i = 0; i < n-1; i++) {
      maxDiff = Math.max(maxDiff, Math.abs(orders[(i+1)] - orders[i]));
    }
    // 마지막으로 맨 뒤에 거랑 맨 앞에 거 차이
    maxDiff = Math.max(maxDiff, Math.abs(orders[n-1] - orders[0]));
    return maxDiff;
  }
}