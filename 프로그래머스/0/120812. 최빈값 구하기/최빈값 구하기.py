def solution(array):
    # count 배열 제일 큰 숫자 + 1 만큼
    count = [0]*(max(array)+1)
    
    # 카운트
    for i in array:
        count[i] += 1
    
    answer = 0
    for i in count:
        if i == max(count):
            answer += 1
    
    if answer >=2:
        return -1
    else:
        return count.index(max(count))