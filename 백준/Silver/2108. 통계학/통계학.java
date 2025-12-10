import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int sum = 0;
    int midIndex = n / 2;

    int[] nums = new int[n];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      nums[i]  = Integer.parseInt(br.readLine());
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

      sum += nums[i];
    }
    // 정렬
    Arrays.sort(nums);

    // 산술 평균
    long avg = Math.round((double) sum / n);
    bw.write(avg+"\n");
    // 중앙값
    bw.write(nums[midIndex]+"\n");
    // ---- 최빈값 찾기 ----
    int maxFrequency = Collections.max(map.values());
    // 최빈값 후보 리스트
    List<Integer> frequencyCandidate = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if(entry.getValue() == maxFrequency) {
        frequencyCandidate.add(entry.getKey());
      }
    }
    Collections.sort(frequencyCandidate);

    int frequencyValue;
    if(frequencyCandidate.size() > 1) {
      // 최빈값 여러개면 두 번째로 작은 값 선택
      frequencyValue = frequencyCandidate.get(1);
    } else {
      // 하나면 그 값
      frequencyValue = frequencyCandidate.get(0);
    }
    bw.write(frequencyValue+"\n");

    // 범위
    bw.write(nums[n-1] - nums[0] + "\n");

    bw.close();
  }
}