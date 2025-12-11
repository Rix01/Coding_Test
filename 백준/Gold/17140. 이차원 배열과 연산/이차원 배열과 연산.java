import java.io.*;
import java.util.*;

public class Main {
  static int r, c, k;
  static List<List<Integer>> list;

  static int R_SIZE = 3;
  static int C_SIZE = 3;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken()) - 1; // 인덱스 0부터 시작
    c = Integer.parseInt(st.nextToken()) - 1;
    k = Integer.parseInt(st.nextToken());

    // 초기 3 x 3 배열 입력받기
    list = new ArrayList<>();
    for(int i = 0; i < 3; i++) {
        List<Integer> row = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int col = 0; col < 3; col++) {
          row.add(Integer.parseInt(st.nextToken()));
        }
        list.add(row);
    }

    // 시뮬레이션 시작
    int time = 0;
    while(time <= 100) {
      // 정답 확인
     if(r < R_SIZE && c < C_SIZE) {
       if(list.get(r).get(c) == k) {
         break;  // 정답 발견, 루프 종료
       }
     }

      // count가 100  초과하면 -1 출력 후 종료
      if(time == 100) {
        time = -1;
        break;
      }

      // 연산 선택
      if(R_SIZE >= C_SIZE) {
        doR();
      } else {
        doC();
      }
      time++;
    }

    bw.write(time+"\n");
    bw.close();
  }

  // R연산
  private static void doR() {
    int maxColSize = 0; // 열의 경우 순회하면서 max값 알아내야 함.
    List<List<Integer>> newList = new ArrayList<>();

    // 모든 행 순회하며 정렬 연산 수행
    for(int i = 0; i < R_SIZE; i++) {
      List<Integer> originalRow = list.get(i);
      // 개별 행 정렬 및 재구성
      List<Integer> newRow = sortAndReconstructRow(originalRow);
      newList.add(newRow);
      // 열 최대 길이 갱신
      maxColSize = Math.max(maxColSize, newRow.size());
    }

    C_SIZE = Math.min(100, maxColSize);

    // 모든 행에 부족한만큼 0 채우기
    for(List<Integer> row:newList) {
      while(row.size() < C_SIZE) {
        row.add(0);
      }
    }
    list = newList;
    R_SIZE = list.size();
  }

  // 개별 행에 대한 숫자 카운트 및 정렬, 재구성
  private static List<Integer> sortAndReconstructRow(List<Integer> row) {
    // 카운트 위한 해시맵
    Map<Integer, Integer> countMap = new HashMap<>();

    for(int num:row) {
      if(num==0) continue;  // 0은 무시
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    // 맵을 리스트로 변환
    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());

    // 우선순위 1. 값 | 우선순위2. 키
    entryList.sort((e1, e2) -> {
      if(e1.getValue().equals(e2.getValue())) {
        return e1.getKey().compareTo(e2.getKey());
      }
      return e1.getValue().compareTo(e2.getValue());
    });

    // 배열 재구성
    List<Integer> result = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry:entryList) {
      result.add(entry.getKey()); // 키 넣기
      result.add(entry.getValue()); // 값 넣기

      // 길이 100 넘으면 100까지만 저장하고 종료
      if(result.size() >= 100) {
        return result.subList(0, 100);  // 0~99 인덱스까지의 리스트를 반환
      }
    }
    return result;
  }

  // C연산
  private static void doC() {
    // 어떻게 순회할 것인가? >> 전치 후 다시 전치
    list = transpose(list);

    // 배열 크기 정보 업데이트
    int tempSize = R_SIZE;
    R_SIZE = C_SIZE;
    C_SIZE = tempSize;

    // R연산 수행
    doR();

    // 다시 전치
    list = transpose(list);

    // 배열 크기 정보 다시 역전
    tempSize = R_SIZE;
    R_SIZE = C_SIZE;
    C_SIZE = tempSize;
  }

  // 전치
  private static List<List<Integer>> transpose(List<List<Integer>> originalList) {
    // 전치 배열의 행 개수 == 원래 배열의 최대 열 개수
    // 전치 배열의 열 개수 == 원래 배열의 최대 행 개수 >> 열 개수의 경우 순회하면서 찾아야 함
    int maxColSize = 0;
    for(List<Integer> row : originalList) {
      maxColSize = Math.max(maxColSize, row.size());
    }

    // 전치 배열 초기화
    List<List<Integer>> newList = new ArrayList<>();
    for(int i = 0; i < maxColSize; i++) { // 전치 행렬이니까 col만큼의 행이 생김
      newList.add(new ArrayList<>());
    }

    // 요소 복사
    for(List<Integer> originalRow : originalList) {
      for(int j = 0; j < maxColSize; j++) {
        int value = (j < originalRow.size()) ? originalRow.get(j) : 0;
        // 행 사이즈보다 작으면 해당 열 값 넣고 그게 아니면 0 넣음
        /*
        [1, 2, 3]  // 첫 번째 행
        [4, 5]     // 두 번째 행
        [6]        // 세 번째 행

        [1, 4, 6]
        [2, 5, 0]
        [3, 0, 0]
        * */
        newList.get(j).add(value);  // j행에 value 넣기
      }
    }
    return newList;
  }
}