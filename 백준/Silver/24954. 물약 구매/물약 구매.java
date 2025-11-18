import java.io.*;
import java.util.*;
public class Main {
  static int n;
  static int[] prices;
  static List<List<int[]>> discounts;
  static int minValue = Integer.MAX_VALUE;
  static boolean[] isBought;

  // 백트래킹( 샀는지 안 샀는지 구분할 boolean 배열, 현재 가격 배열,
  //          depth, 현재 값)
  static void backtrack(int depth, boolean[] isBought, int totalPrice, int[] currentPrices) {
    if(depth == n){
      minValue = Math.min(minValue, totalPrice);
      return;
    }

    for(int i = 0; i < n; i++) {
      // 안 샀으면
      if(!isBought[i]) {
        List<int[]> buyPotion = discounts.get(i);

        // 다음 재귀에 넘길 새로운 가격 상태 만들기
        int[] nextPrices = Arrays.copyOf(currentPrices, n);

        isBought[i] = true;
        int cost = currentPrices[i];

        // discounts를 통해 할인 가격으로 갱신
        for(int[] dis: buyPotion) {
          // dis[0] - 1: 할인 포션 인덱스 / dis[1] 할인 가격
          nextPrices[dis[0]-1] = Math.max(1, nextPrices[dis[0]-1] - dis[1]);
        }

        // 재귀
        backtrack(depth+1, isBought, totalPrice + cost, nextPrices);

        isBought[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(reader.readLine());

    // 물약 가격 입력받기
    prices = new int[n];
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    for(int i = 0; i < n; i++) {
      prices[i] = Integer.parseInt(tokenizer.nextToken());
    }

    discounts = new ArrayList<>();
    // 물약 할인 입력받기
    // 리스트 초기화
    for(int i = 0; i < n; i++) {
      discounts.add(new ArrayList<>());
    }

    for(int i = 0; i < n; i++) {
      int discountCnt = Integer.parseInt(reader.readLine());
      for(int j = 0; j < discountCnt; j++) {
        tokenizer =  new StringTokenizer(reader.readLine());
        int discountPotion = Integer.parseInt(tokenizer.nextToken());
        int discountPrice = Integer.parseInt(tokenizer.nextToken());

        discounts.get(i).add(new int[]{discountPotion, discountPrice});
      }
    }

    isBought = new boolean[n];
    // 백트래킹
    backtrack(0, isBought, 0, prices);

    // 결과 출력
    writer.write(minValue + "\n");
    writer.close();
  }
}