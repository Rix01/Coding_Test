def solution(progresses, speeds):
    leftProgresses = []
    new_speeds = []
    # prgoresses -> leftProgresses
    for i in progresses:
        leftProgresses.append(100-i)

    answer = []
    day = 1
    cnt = 0
    flag = 0
    while(len(leftProgresses)!=0):
        # speeds 새롭게
        new_speeds = []
        
        for s in speeds:
            new_speeds.append(s*day)
        
        first = leftProgresses[0]
        
        if(first<=new_speeds[0]):
            leftProgresses.pop(0)
            speeds.pop(0)
            cnt+=1
            flag = 1
        else:
            if(flag==1):
                answer.append(cnt)
                cnt = 0
                flag = 0
            day+=1
    # while문 끝났는데 flag = 1이라면
    if(flag==1):
        answer.append(cnt)
    return answer