def solution(s):
    stack = []
    for i in s:
        if(i=="("):
            stack.append(i)
        elif(i==")"):
            # stack이 0이라면
            if(len(stack)==0):
                return False
            stack.pop()
    if(len(stack)==0):
        return True
    else:
        return False