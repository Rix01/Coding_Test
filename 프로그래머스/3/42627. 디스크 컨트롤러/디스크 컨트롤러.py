from heapq import heappop, heappush

def solution(jobs):
    answer = 0
    now = 0 # 현재 시간
    complete = 0 # 완료한 프로세스
    preTime = -1 # 전 프로세스 완료 시간
    waitingHeap = []

    while(complete<len(jobs)):
        for j in jobs:
            if(preTime<j[0]<=now):
                heappush(waitingHeap, [j[1], j[0]])
        
        if(len(waitingHeap)>0):
            job = heappop(waitingHeap)
            preTime = now
            now += job[0]
            complete+=1
            answer += now - job[1]

        else:
            now+=1
    return answer//len(jobs)
