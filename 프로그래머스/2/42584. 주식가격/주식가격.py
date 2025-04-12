def solution(prices):
    answer = []
    for i in range(len(prices)-1):
        compareValue = prices[i]
        for j in range(i+1, len(prices), 1):
            if(compareValue>prices[j]):
                break
        answer.append(j-i)
    # 마지막은 무조건 0
    answer.append(0)
    return answer