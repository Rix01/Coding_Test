from collections import deque

def solution(bridge_length, weight, truck_weights):
    # 건너는 중인 트럭
    bridge_ing = deque()
    bridge_cnt = deque()
    waiting = deque(truck_weights)
    curr_weight = weight
    time = 0
    
    while(True):
        time+=1
        # 다리 지나고 있는 트럭이 있고 다 건넜다면 그 트럭 꺼냄
        if(len(bridge_ing)!=0 and bridge_cnt[0]==bridge_length):
            end_truck = bridge_ing.popleft()
            curr_weight+=end_truck
            bridge_cnt.popleft()

        # 다리 위에 있는 트럭들 다 +1 time이 지남에 따라.
        for i in range(len(bridge_cnt)):
            bridge_cnt[i]+=1
        
        # 건너는 중인 트럭도 없고 기다리는 중인 트럭도 없다면 끝냄
        if(len(bridge_ing) == 0 and len(waiting)==0):
            return time

        # 기다리고 있는 트럭이 존재하고, 맨 앞에서 기다리는 트럭이 다리에 올라가는 게 가능한 경우
        if(len(waiting)!=0 and waiting[0]<=curr_weight and len(bridge_ing)<bridge_length):
            truck = waiting.popleft()
            bridge_ing.append(truck)
            bridge_cnt.append(1)
            curr_weight -= truck