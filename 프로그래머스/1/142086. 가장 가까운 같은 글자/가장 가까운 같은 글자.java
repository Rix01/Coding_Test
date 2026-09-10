import java.io.*;
import java.util.*;

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                answer[i] = -1;
            }
            else {
                answer[i] = i - map.get(c);
            }
            map.put(c, i);
        }
        return answer;
    }
}

/*
banana
b -1
a -1
n -1
a 2
n 2
a 2

인덱스 순서대로 도니까 현재 인덱스 위치 넣으면 되는 거 아냐
해시맵 안에 없으면 -1이고

그렇게 되면 banana를 할 때
---
처음 b 없음 -> b:현재인덱스 넣음
a a: 현재 인덱스
n n: 현재 인덱스
a 맵에서 찾고 현재 인덱스로 갱신

*/