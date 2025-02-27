def solution(arr):
    answer = []
    
    # 배열 길이가 1이면 그냥 arr 리턴
    if(len(arr)==1):
        return arr
    
    # 새로운 수를 만날 때까지 append 안 함
    new = arr[0]
    answer.append(new)
    for i in arr:
        if(i==new):
            continue
        else:
            answer.append(i)
            new = i
    
    return answer