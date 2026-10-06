import java.io.*;
import java.util.*;

class Solution {
    int maxLen;
    boolean[] visited;
    String[] numberCards;
    List<String> numbersPermutation = new ArrayList<>();
    
    public int solution(String numbers) {
        this.maxLen = numbers.length();
        this.visited = new boolean[maxLen];
        
        // 일단 numbers 나누기
        this.numberCards = numbers.split("");
        
        // numberCards로 순열 만들기
        for(int r = 1; r <= maxLen; r++) {
            permutation(0, r, new StringBuilder());
        }
        
        // 순열에 있는 수 숫자로 변환하고 Set으로 같은 수 추출하기
        Set<Integer> numberSet = new HashSet<>();
        
        for(String numStr:numbersPermutation) {
            numberSet.add(Integer.parseInt(numStr));
        }
        
        int answer = 0;
        // 소수 구하기
        for(int num:numberSet) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void permutation(int depth, int r, StringBuilder now) {
        if(depth == r) {
            numbersPermutation.add(now.toString());
            return;
        }
        
        for(int i = 0; i < maxLen; i++) {
            if(!visited[i]) {
                visited[i] = true;
                now.append(numberCards[i]); // StringBuilder 추가
                
                permutation(depth+1, r, now);
                
                now.deleteCharAt(now.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        
        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}