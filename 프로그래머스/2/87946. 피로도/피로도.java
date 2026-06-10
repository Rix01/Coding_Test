import java.io.*;
import java.util.*;

class Solution {
    boolean[] visited;
    int[][] dungeons;
    int count;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.count = dungeons.length;
        this.visited = new boolean[count];
        
        return dfs(0, k);
    }
    
    public int dfs(int level, int hp) {
        answer = Math.max(level, answer);
        
        for(int i = 0; i < count; i++) {
            if(!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true;
                dfs(level + 1, hp - dungeons[i][1]);
                visited[i] = false;
            }
        }
        return answer;
    }
}