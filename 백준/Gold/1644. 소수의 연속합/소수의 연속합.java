import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean[] isPrime = new boolean[4_000_001];
    List<Integer> primes = new ArrayList<>();

    // isPrime 배열 초기화
    for (int i = 2; i <= 4_000_000; i++) {
      isPrime[i] = true;
    }

    // 에라토스테네스의 체
    for (int i = 2; i * i <= 4_000_000; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= 4_000_000; j += i) {
          isPrime[j] = false;
        }
      }
    }

    // 소수 리스트에 추가
    for (int i = 2; i <= 4_000_000; i++) {
      if (isPrime[i]) {
        primes.add(i);
      }
    }

    // n입력 받기
    int n = Integer.parseInt(br.readLine());

    // 투 포인터 이용해서 가능한지 찾기
    int start = 0, end = 0;
    long hap = 0;
    int count = 0;

    // end 포인터가 리스트 끝에 도달할 때까지 반복
    while (end < primes.size()) {
      if (hap < n) {
        // 합이 작으면 end를 늘려서 값을 더함
        hap += primes.get(end);
        end++;
      } else {
        // 합이 같거나 크면 start를 늘려서 값을 뺌
        if (hap == n) {
          count++;
        }
        hap -= primes.get(start);
        start++;
      }
    }
    
    // end에 도달했어도 hap이 n보다 크다면 start를 옮겨서 찾을 수 있음
    while (hap >= n) {
      if (hap == n) {
        count++;
      }
      hap -= primes.get(start);
      start++;
    }

    bw.write(String.valueOf(count) + "\n");
    bw.close();
  }
}