import java.io.*;
import java.util.*;

class Solution {
    int[] number;
    int numberLen;
    boolean[] visited;
    int answer = 0;
    
    public int solution(int[] number) {
        this.number = number;
        this.numberLen = number.length;
        this.visited = new boolean[numberLen];
        
        combination(0, 0, 0);
        return answer;
    }
    
    public void combination(int depth, int hap, int start) {
        if(depth == 3) {
            if(hap == 0) {
                answer++;
            }
        }
        
        for(int i = start; i < numberLen; i++) {
            if(visited[i] == true) {
                continue;
            }
            visited[i] = true;
            combination(depth+1, hap + number[i], i+1);
            visited[i] = false;
        }
        
    }
}

/*
3명의 정수 번호를 더했을 때 0이 되면 삼총사

삼총사 만드는 방법 수 리턴

뭔가 조합 이용해서 합 0 될 때마다 ++해주면 될 것 같은데

List<int[]> 형태로 하면 될 듯.



*/