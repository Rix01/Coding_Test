import java.io.*;
import java.util.*;

class Solution {
    Deque<Truck> deque = new ArrayDeque<>();
    Deque<Truck> bridge = new ArrayDeque<>();
    
    public int solution(int bridge_length, int maxWeight, int[] truck_weights) {
        
        for(int weight:truck_weights) {
            deque.addLast(new Truck(0, weight));
        }
        
        int time = 0;
        int bridgeTotal = 0;
        while(!deque.isEmpty() || !bridge.isEmpty()) {
            time++;
            
            // 시간이 지났으니 다리 위에 있는 트럭들 머무른 시간 전체적으로 다 +1
            for(int i = 0; i < bridge.size(); i++) {
                Truck truck = bridge.pollFirst();
                truck.time += 1;
                bridge.addLast(truck);
            }
            
            // 다리 위에 있는 트럭 확인
            if(bridge.isEmpty()) { // 아무것도 없음
                Truck nowTruck = deque.pollFirst(); // 대기에 있는 트럭
                bridge.addLast(nowTruck); // 다리에 올려놓기
                nowTruck.time += 1; // length만큼 있으면 되니까 그만큼 계산하기 위해 필요
                bridgeTotal += nowTruck.weight;
            } else { // 트럭 있으면
                
                // 끝난 거 있는지 확인
                if(bridge.peekFirst().time > bridge_length) { // 이제 다 건넜으면
                    Truck endTruck = bridge.pollFirst();
                    bridgeTotal -= endTruck.weight; // 다리에서 빼기
                }
                
                // 트럭 수 확인
                if(!deque.isEmpty() && bridge.size() < bridge_length) {
                    Truck nextTruck = deque.peekFirst();
                    if(nextTruck.weight + bridgeTotal <= maxWeight) {
                        nextTruck = deque.pollFirst();
                        bridge.addLast(nextTruck);
                        nextTruck.time += 1;
                        bridgeTotal += nextTruck.weight;
                    }
                }
            }
        }
        
        return time;
    }
    
    public class Truck {
        int time;
        int weight;
        
        public Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }
}