import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        // 오름차순 정렬
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int count = 0;
        int zeroCount = 0;
        
        for(int lotto:lottos) {
            if(lotto==0) {
                zeroCount++;
            }
            for(int winNum:win_nums) {
                if(lotto == winNum) {
                    count++;
                }
            }
        }
        
        // 0이 없으면 끝
        if(calculateRank(count) == 1) {
            return new int[]{1,1};
        }
        
        // 최고 순위
        int maxRank = calculateRank(count) - zeroCount;
        if(maxRank == 0) {
            maxRank = 1;
        }
        
        // 최저 순위
        int minRank = calculateRank(count);
        System.out.println(maxRank + " " + minRank );
        
        return new int[]{maxRank, minRank};
    }
    
    public int calculateRank(int count) {
    if(count == 6) {
        return 1;
    }
    if(count == 5) {
        return 2;
    }
    if(count == 4) {
        return 3;
    }
    if(count==3) {
        return 4;
    }
    if(count==2) {
        return 5;
    }
    return 6;
}
}


/*
44, 1, 0, 0, 31 25
31 10 45 1 6 19

// 오름차순 정렬
0 0 1 25 31 44
1 6 10 19 31 45

// 겹치는 거 제외
0 0 25 44
6 10 19 45

// 최고 순위는 0인 것들 다 당첨번호인 경우
// 최지 순위는 0인 것들 다 당첨번호 아닌 경우

// [최고 순위, 최저 순위] 형태로 출력


*/