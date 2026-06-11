import java.io.*;
import java.util.*;

class Solution {
    Map<Mineral, Hp> hpMap = new HashMap<>();
    List<PerFive> perFives = new ArrayList<>();
    
    public int solution(int[] picks, String[] minerals) {
        Hp diaHp = new Hp(1, 1, 1);
        Hp ironHp = new Hp(5, 1, 1);
        Hp stoneHp = new Hp(25, 5, 1);

        hpMap.put(Mineral.DIAMOND, diaHp);
        hpMap.put(Mineral.IRON, ironHp);
        hpMap.put(Mineral.STONE, stoneHp);
        
        // 곡괭이 개수
        int pickCnt = 0;
        for(int i = 0; i < picks.length; i++) {
            pickCnt += picks[i];
        }
        
        // 5개씩 쪼개고 score 매겨서 우선순위 큐에 넣기
        for(int i = 0; i < minerals.length; i += 5) {
            List<Mineral> splitMinerals = new ArrayList<>();
            for(int j = i; j < Math.min(i + 5, minerals.length); j++) {
                if(minerals[j].equals("diamond")) {
                    splitMinerals.add(Mineral.DIAMOND);
                }
                if(minerals[j].equals("iron")) {
                    splitMinerals.add(Mineral.IRON);
                }
                if(minerals[j].equals("stone")) {
                    splitMinerals.add(Mineral.STONE);
                }
            }
            if(perFives.size() == Math.min(pickCnt, (minerals.length + 4) / 5)) {
                break;
            }
            perFives.add(new PerFive(splitMinerals));
        }
        
        // 우선순위 큐에 넣기
        PriorityQueue<PerFive> pq = new PriorityQueue<>();
        for(PerFive pf:perFives) {
            pq.offer(pf);
        }
        
        int result = 0;
        
        // picks 순서대로 뽑아서 계산
        for(int i = 0; i < 3; i++) {
            // 곡괭이 선택
            Mineral tool = selectTool(i);
            for(int j = 0; j < picks[i]; j++) {
                if(pq.isEmpty()) break;
                PerFive pf = pq.poll();
                List<Mineral> pfMinerals = pf.mList;
                for(Mineral m : pfMinerals) {
                    if(m == Mineral.DIAMOND) {
                        result += hpMap.get(tool).dHp;
                    }
                    if(m == Mineral.IRON) {
                        result += hpMap.get(tool).iHp;
                    }
                    if(m == Mineral.STONE) {
                        result += hpMap.get(tool).sHp;
                    }
                }
            }
        }
        
        return result;
    }
    
    public Mineral selectTool(int idx) {
        if(idx == 0) {
            return Mineral.DIAMOND;
        }
        
        if(idx == 1) {
            return Mineral.IRON;
        }
        
        return Mineral.STONE;
    }
    
    class Hp {
        int dHp;
        int iHp;
        int sHp;
        
        Hp(int dHp, int iHp, int sHp) {
            this.dHp = dHp;
            this.iHp = iHp;
            this.sHp = sHp;
        }
    }
    
    enum Mineral {
        DIAMOND("diamond", 25),
        IRON("iron", 5),
        STONE("stone", 1);
        
        String name;
        int value;
        
        Mineral(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
    
    class PerFive implements Comparable<PerFive>{
        List<Mineral> mList = new ArrayList<>();
        int score = 0;
        
        PerFive(List<Mineral> mList) {
            this.mList = mList;
            calculateScore(mList);
        }
        
        public void calculateScore(List<Mineral> mList) {
            for(int i = 0; i < mList.size(); i++) {
                score += mList.get(i).value;
            }
        }
        
        @Override
        public int compareTo(PerFive other) {
            return Integer.compare(other.score, this.score);
        }
    }
}

/*
최소의 피로도
곡괭이를 다 쓰거나 캐야 할 광물이 없을 때까지 반복

곡괭이는 3가지 0~5개
- 다이아몬드 3
- 철 2
- 돌 1

광물 5개 연속으로 캐고, 다음 곡괭이를 선택해서 광물 5개를 연속으로

[dia, iron, stone]
[0, 1, 1]

["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]

5 + 5 + 5 + 5 + 5 + 5 + 5 + 5 + 5 + 

*/