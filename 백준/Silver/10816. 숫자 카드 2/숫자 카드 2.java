import java.io.*;
import java.util.*;

public class Main
{
  private static int n, m;
  private static Map<Integer, Integer> nCardsCount;
  private static int[] mCards;

  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    nCardsCount = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      int nCard = Integer.parseInt(st.nextToken());
      nCardsCount.put(nCard, nCardsCount.getOrDefault(nCard, 0) + 1);
    }

    m = Integer.parseInt(br.readLine());
    mCards = new int[m];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < m; i++){
      mCards[i] = Integer.parseInt(st.nextToken());
    }

    // 숫자 값 넣으면 nCardsCount에서 찾기
    for(int m:mCards){
      // nCardsCount에 있다면
      if(nCardsCount.containsKey(m)){
        bw.write(nCardsCount.get(m) + " ");
      } else {
        bw.write("0 ");
      }
    }
    bw.close();
  }
}
