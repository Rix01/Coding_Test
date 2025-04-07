def solution(priorities, location):
    # 내가 알아내고 싶은 거 위치 알기 위해
    index_q = [0]*len(priorities)
    # 알아내고자 하는 것만 1로 표시
    index_q[location] = 1

    cnt = 0
    while(True):
        now = priorities.pop(0)
        check = index_q.pop(0)
        if(len(priorities)==0):
            return cnt+1
        if(now >= max(priorities)):
            cnt+=1
            if(check==1):
                return cnt
        else:
            priorities.append(now)
            index_q.append(check)