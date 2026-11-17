import java.io.*;
import java.util.*;

class Solution {
    int[] plusMinus = {-1, 1}; // 2가지 종류 가능
    int[] numbers;
    int numberLen;
    List<int[]> combination = new ArrayList<>();
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.numberLen = numbers.length;
        int answer = 0;
        
        dfs(0, new int[numberLen]);
        
        for(int[] comb:combination) {
            int sum = 0;
            for(int c:comb) {
                sum += c;
            }
            
            if(sum == target) {
                answer++;
            }
        }
        return answer;
    }
    
    // 조합 구하기
    public void dfs(int depth, int[] current) {
        if(depth == numberLen) {
            combination.add(current.clone());
            return;
        }
        
        for(int i = 0; i < plusMinus.length; i++) {
            current[depth] = numbers[depth] * plusMinus[i];
            dfs(depth+1, current);
            current[depth] = 0;
        }   
        
    }
}