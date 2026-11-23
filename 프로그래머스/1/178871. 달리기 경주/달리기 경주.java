import java.io.*;
import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String callName:callings) {
            int originalRank = map.get(callName);
            int prevRank = originalRank - 1;
            String prevName = players[prevRank];
            
            // change Array
            players[originalRank] = prevName;
            players[prevRank] = callName;
            
            // change Map
            map.put(callName, prevRank);
            map.put(prevName, originalRank);
        }
        
        return players;
    }
}