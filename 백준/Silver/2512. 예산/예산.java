import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[] local;
  static int m;
  static int start, end, mid;
  static int maxValue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    local = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      local[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(local);

    m = Integer.parseInt(br.readLine());

    // 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정
    int sum = Arrays.stream(local).sum();
    int result = 0;
    if(sum<=m) {
      result = local[n-1];
    } else {
      result = calculate();
    }

    bw.write(result + "\n");
    bw.close();
  }

  static int calculate() {
    int avg = m / n;
    int localMaxValue = local[n-1];  // 정렬 이후의 맨 마지막 값
    start = avg;
    end = localMaxValue;

    while(start <= end)
    {
      mid = (start + end) / 2;  // 상한액
      int sum = 0;
      // 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산
      for(int money:local)
      {
        if(money <= mid) {
          sum += money;
        } else {
          sum += mid;
        }
      }

      // 예산보다 작은지 큰지 확인
      if(sum <= m) {
        start = mid + 1;
        maxValue = Math.max(maxValue, mid);
      } else {
        end = mid - 1;
      }
    }
    return maxValue;
  }
}