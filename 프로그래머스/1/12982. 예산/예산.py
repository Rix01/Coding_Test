def solution(d, budget):
    # d 일단 정렬
    d.sort()
    answer = 0
    total = 0
    for i in range(len(d)):
        total += d[i]
        if(total>budget):
            answer = i
            break
    if(total <= budget):
        answer = len(d)
    return answer