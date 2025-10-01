from collections import deque

def solution(prices):
    answer = []
    queue = deque(prices)

    while queue:
        current = queue.popleft()
        cnt = 0
        for next_price in queue:
            if current <= next_price:
                cnt += 1
            else:
                cnt += 1
                break
        answer.append(cnt)

    return answer
