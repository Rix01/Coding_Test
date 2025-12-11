import java.io.*;
import java.util.*;

public class Main {

  static int n, c;
  static int[] weights;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    weights = new int[n];

    st = new StringTokenizer(br.readLine());
    // 입력 배열 채우기
    for (int i = 0; i < n; i++) {
      weights[i] = Integer.parseInt(st.nextToken());
    }

    // 정렬
    Arrays.sort(weights);

    int result = 0;

    // 1개짜리 조합 확인
    if (checkOne()) {
      result = 1;
    }

    // 2개짜리 조합 확인
    else if (checkTwo()) {
      result = 1;
    }

    // 3개짜리 조합 확인
    else if (checkThree()) {
      result = 1;
    }

    bw.write(result + "\n");
    bw.close();
    br.close();
  }

  // 1개짜리 물건의 무게가 C와 같은지 확인
  private static boolean checkOne() {
    for (int w : weights) {
      if (w == c) {
        return true;
      }
    }
    return false;
  }

  // 2개짜리 물건의 무게 합이 C와 같은지 확인
  private static boolean checkTwo() {
    int left = 0;
    int right = n - 1;

    while (left < right) {
      int sum = weights[left] + weights[right];
      if (sum == c) {
        return true;
      } else if (sum < c) {
        left++; // 합을 늘려야 함
      } else {
        right--; // 합을 줄여야 함
      }
    }
    return false;
  }

  // 3개짜리 물건의 무게 합이 C와 같은지 확인 (반복문 + 투 포인터)
  private static boolean checkThree() {
    // 첫 번째 물건 weights[i] 선택
    for (int i = 0; i < n - 2; i++) {
      int targetTwoSum = c - weights[i]; // 나머지 두 물건이 만들어야 할 합

      // 남은 배열(i+1 ~ n-1)에서 targetTwoSum을 만드는 2개의 물건을 투 포인터로 찾음
      int left = i + 1;
      int right = n - 1;

      while (left < right) {
        int sum = weights[left] + weights[right];

        if (sum == targetTwoSum) {
          return true;
        } else if (sum < targetTwoSum) {
          left++; // 합을 늘려야 함
        } else {
          right--; // 합을 줄여야 함
        }
      }
    }
    return false;
  }
}