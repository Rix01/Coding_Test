import java.io.*;
import java.util.*;
public class Main {
  static int l, c;
  static char[] alphas;
  static List<String> result = new ArrayList<>();

  public static void main(String[] args) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    l =  Integer.parseInt(tokenizer.nextToken());
    c =  Integer.parseInt(tokenizer.nextToken());

    alphas = new char[c];
    tokenizer = new StringTokenizer(reader.readLine());
    for(int i = 0; i < c; i++) {
      alphas[i] = tokenizer.nextToken().charAt(0);
    }

    Arrays.sort(alphas);

    char[] initAlphas = new char[l];
    // 백트래킹
    backtrack(0, initAlphas, 0, 0, 0);

    for(String s : result){
      writer.write(s + "\n");
    }
    writer.close();
  }

  static void backtrack(int depth, char[] currentAlphas, int startIndex,
      int vowelCount, int consonantCount) {
    if(depth == l) {
      if(vowelCount >= 1 && consonantCount >= 2) {
        result.add(String.valueOf(currentAlphas));
      }
      return;
    }

    // 가지치기 - 남은 문자 개수 확인하여 불가능하면 리턴
    if(l - depth > c - startIndex) {
      return;
    }

    // 재귀를 위한 반복문
    for(int i = startIndex; i < c; i++) {
      char nextAlpha = alphas[i];
      currentAlphas[depth] = nextAlpha;
      int nextVowelCount = vowelCount + (isVowel(nextAlpha) ? 1 : 0);
      int nextConsonantCount = consonantCount + (isVowel(nextAlpha) ? 0 : 1);
      backtrack(depth+1, currentAlphas, i+1, nextVowelCount, nextConsonantCount);
    }
  }

  // 자음인가 모음인가
  static boolean isVowel(char c) {
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
      return true;
    }
    return false;
  }
}