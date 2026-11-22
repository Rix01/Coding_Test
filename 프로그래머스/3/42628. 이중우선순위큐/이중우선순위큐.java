import java.io.*;
import java.util.*;

class Solution {
    TreeMap<Integer, Integer> tm = new TreeMap<>(); // 오름차순으로
    
    public int[] solution(String[] operations) {
        for(String operation:operations) {
            String[] splitOp = operation.split(" ");
            String operator = splitOp[0];
            int num = Integer.parseInt(splitOp[1]);
            
            if(operator.equals("I")) {
                tm.put(num, tm.getOrDefault(num, 0) + 1);
            }
            else if(operator.equals("D")) {
                if(!tm.isEmpty()) {
                    if(num == -1) {
                        int minKey = tm.firstKey();

                        if(tm.get(minKey) == 1) {
                            tm.remove(minKey);
                        } else {
                            tm.put(minKey, tm.get(minKey) - 1);
                        }
                    }
                    else if(num == 1) {
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