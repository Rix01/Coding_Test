import java.io.*;
import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int targetLength;
    String begin;
    String target;
    boolean[] visited;
    String[] words;
    
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        this.targetLength = target.length();
        this.visited = new boolean[words.length];
        
        // 1. 그러니까 일단은 words에 target이 있는지 확인하고 없으면 바로 0리턴
        boolean inFlag = false;
        for(String word:words) {
            if(word.equals(target)) {
                inFlag = true;
            }
        }
        if(!inFlag) {
            return 0;
        }
        
        // 2. words 배열 길이만큼 완탐 돌기.
        dfs(begin, 0);
        
        
        // 3. 지금 단어(nowWord, level) 돌면서 백트래킹 하면 될 것 같은데. for문은 단어 길이만큼 돌고
        return answer;
    }
    
    public void dfs(String nowWord, int level) {
        if(nowWord.equals(target)) {
            answer = Math.min(answer, level);
        }
        
        for(int i = 0; i < targetLength; i++ ){
            // 현재 인덱스를 X로 뒀을 때
            String head = nowWord.substring(0, i);
            String tail = nowWord.substring(i+1);
            
            // words에 있는지 확인
            for(int j = 0; j < words.length; j++) {
                String wordHead = words[j].substring(0, i);
                String wordTail = words[j].substring(i+1);
                if(!visited[j] && head.equals(wordHead) && tail.equals(wordTail)) {
                    // 방문 처리
                    visited[j] = true;
                    String goalStr = wordHead + words[j].charAt(i) + wordTail;
                    
                    dfs(goalStr, level + 1);
                    
                    visited[j] = false;
                }
            }
        }
    }
}

/*

abcdefghijklmnopqrstuvwxyz

hit -> cog
["hot", "dot", "dog", "lot", "log", "cog"]
hit -> hot -> dot -> dog -> cog =>> 4
hit에서 0번째 글자 h Xit 불가
hit에서 1번째 글자 o hXt >> hot
    hot에서 0번째 글자 Xot >> dot
        dot에서 0번째 글자 Xot >> lot
            lot에서 0번째 글자 Xot 불가
            lot에서 1번째 글자 lXt 불가
            lot에서 2번째 글자 loX >> log
                log에서 0번째 글자 xOg >> "cog" 5번
        dot에서 1번째 글자 dXt 불가
        dot에서 2번째 글자 doX >> dog
            dog에서 0번째 글자 c "cog" 4번
    hot에서 1번째 글자 o d
    hot에서 2번째 글자 g x
hit에서 2번째 글자 g x

["hot", "dot", "dog", "lot", "log"]
일단 words에 target이 있는지 확인하고 없으면 바로 0 리턴

-=-=-=--=-=-==-=-=-=-==-=--=---==-=--==-=-=---=-=-=
1. 그러니까 일단은 words에 target이 있는지 확인하고 없으면 바로 0리턴
2. target 단어 길이만큼 완탐 돌기. 백트래킹?
3. 지금 단어(nowWord, level) 돌면서 백트래킹 하면 될 것 같은데. for문은 단어 길이만큼 돌고

*/