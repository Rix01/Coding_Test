n, m = map(int, input().split())

tteoks = list(map(int, input().split()))

def checkHeight(array, target, start, end):
    while(start<=end):
        total = 0
        height = (start+end)//2
        for i in array:
            leave = i - height
            if(leave>0):
                total += leave

        if(total==target):
            return height

        elif(total>target):
            start = height+1

        elif(total<target):
            end = height-1

    return height

result = checkHeight(tteoks, m, 0, max(tteoks))
print(f"최대 높이 : {result}") 