import java.util.*;
import java.io.*;

public class Main {
  static boolean[] isPrime = new boolean[4_000_001];
  static List<Integer> primes = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // n 입력 받기
    int n = Integer.parseInt(br.readLine());

    // n까지의 정수까지의 Prime Number 배열 구하기
    primes = getPrimes(n);

    // 투 포인터로 찾기
    int start = 0, end = 0, sum = 0, count = 0;

    while(end < primes.size()) {
      if(sum < n) {
        sum += primes.get(end++);
      } else {
        if(sum==n) count++;
        sum -= primes.get(start++);
      }
    }

    while(sum>=n) {
      if(sum==n) count++;
      sum -= primes.get(start++);
    }

    bw.write(String.valueOf(count) + "\n");
    bw.close();
  }

  static List<Integer> getPrimes(int n) {
    // isPrime true로 초기화
    for(int i = 2; i <=n ; i++) {
      isPrime[i] = true;
    }

    // 에라토스테네스 체 이용해서 소수 구하기
    for(int i = 2; i*i <=n; i++) {
      if(isPrime[i]) {
        for(int j = i*i; j <=n; j+=i ) {
          isPrime[j] = false;
        }
      }
    }

    // isPrime[i] == true인 거 소수 리스트에 넣기
    for(int i = 2; i<=n; i++) {
      if(isPrime[i]) {
        primes.add(i);
      }
    }
    return primes;
  }
}