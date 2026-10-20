import java.io.*;
import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int n, int k) {
        
        // k진수로 바꾸면서 배열에 넣기 StringBuilder -> String
        String kString = convertToK(n, k);
        System.out.println(kString);
        
        // k진수로 바꾼 이후에 0 기준으로 나누기 String -> String[]
        String[] splitByZero = kString.split("0+");
        
        // 소수 판별하기 String[]을 int로 반환한 후, 소수 맞으면 answer에 넣기
        for(String s:splitByZero) {
            Long num = Long.parseLong(s);
            checkPrimeNumber(num); // 소수 맞는지 판별
        }
        
        return answer;
    }
    
    public String convertToK(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            int mok = n / k; // 몫
            int last = n % k; // 나머지
            n = mok;
            
            if(k > mok) {
                sb.append(last);
                sb.append(mok);
                break; // 멈춤
            }
            
            sb.append(last);
        }
        
        return sb.reverse().toString();
    }
    
    public void checkPrimeNumber(long num) {
        if(num == 1) {
            return;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) {
                return;
            }
        }
        answer++;
    }
}