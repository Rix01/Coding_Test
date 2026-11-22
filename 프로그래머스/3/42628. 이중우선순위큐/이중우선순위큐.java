import java.io.*;
import java.util.*;

class Solution {
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    
    public int[] solution(String[] operations) {
        
        for(String operation:operations) {
            String[] splitOp = operation.split(" ");
            int number = Integer.parseInt(splitOp[1]);
            if(splitOp[0].equals("I")) {
                // tm에 넣기
                tm.put(number, tm.getOrDefault(number, 0) + 1);
            }
            else if(splitOp[0].equals("D")) {
                if(!tm.isEmpty()) { // tm이 비어있지 않으면
                    if(number == -1) { // 최솟값 꺼내기
                        int minKey = tm.firstKey();
                        if(tm.get(minKey) == 1) {
                            tm.remove(minKey);
                        } else {
                            tm.put(minKey, tm.get(minKey) - 1);
                        }
                    }
                    else if(number == 1) { // 최댓값 꺼내기
                        int maxKey = tm.lastKey();
                        if(tm.get(maxKey) == 1) {
                            tm.remove(maxKey);
                        } else {
                            tm.put(maxKey, tm.get(maxKey) - 1);
                        }
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        if(tm.isEmpty()) {
            return answer;
        }
        
        answer[0] = tm.lastKey();
        answer[1] = tm.firstKey();
        
        return answer;
    }
}