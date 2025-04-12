from heapq import heapify, heappush, heappop

def solution(scoville, K):
    heapify(scoville)
    mixCnt = 0
    while(True):
        if(scoville[0]>=K):
            return mixCnt
        if(len(scoville)==1):
            return -1
        min1 = heappop(scoville)
        min2 = heappop(scoville)
        new = min1 +(min2*2)
        mixCnt+=1
        heappush(scoville, new)