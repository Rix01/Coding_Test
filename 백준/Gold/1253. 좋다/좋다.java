import java.io.*;
import java.util.*;

public class Main {
  private static int n;
  private static long[] numbers;
  private static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    numbers = new long[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      numbers[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(numbers);

    for(int i = 0; i < n; i++) {
      findGood(i);
    }

    bw.write(count+"\n");
    bw.close();
  }

  public static void findGood(int goalIdx) {
    long goal = numbers[goalIdx];
    int start = 0, end = n - 1;

    while (start < end) {
      // goalIdx와 겹치는지 확인
      if(start == goalIdx) {
        start++;
        continue;
      }
      if(end == goalIdx) {
        end--;
        continue;
      }

      long value = numbers[start] + numbers[end];
      if(value == goal) {
        count++;
        break;
      }
      else if(value > goal) {
        end -= 1;
      }
      else if(value < goal) {
        start += 1;
      }
    }
  }
}