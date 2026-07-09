import java.io.*;
import java.util.*;

class Solution {
    List<Integer>[] children;
    int[] info;
    int answer = 0;
    
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        // 자식을 인접 리스트로 표현
        // [노드 인덱스] : {자식들}
        children = new ArrayList[info.length];
        
        // 일단 빈 인접 리스트 만들기
        for(int i = 0 ; i < info.length; i++) {
            children[i] = new ArrayList<>();
        }
        
        // edges 기준으로 정리
        // edge[0]은 부모, edge[1]은 자식
        for(int[] edge : edges) {
            children[edge[0]].add(edge[1]);
        }
        
        // 0부터 시작
        List<Integer> availableNodes = new ArrayList<>();
        availableNodes.add(0);
        
        dfs(0, 0, availableNodes);
        
        return answer;
    }
    
    public void dfs(int sheep, int wolf, List<Integer> availableNodes) {
        // 가능한 노드 돌면서 확인
        for(int i = 0; i < availableNodes.size(); i++) {
            int current = availableNodes.get(i); // 현재 가능한 노드 인덱스
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            // 양인지 늑대인지 확인
            if(info[current] == 0) {
                nextSheep++;
            } else {
                nextWolf++;
            }
            
            if(nextWolf >= nextSheep) {
                continue; // 실패
            }
            
            answer = Math.max(answer, nextSheep); // 양 개수 최대로 갱신
            
            // 가능 노드 리스트 새롭게
            List<Integer> nextAvailableNodes = new ArrayList<>(availableNodes);
            // 방금 지나온 노드 없애기
            nextAvailableNodes.remove(i);
            
            // 방금 지나온 노드의 자식 넣기
            nextAvailableNodes.addAll(children[current]);
            
            dfs(nextSheep, nextWolf, nextAvailableNodes);
        }
    }
}