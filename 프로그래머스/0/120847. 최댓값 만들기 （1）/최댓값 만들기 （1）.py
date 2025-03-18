def solution(numbers):
    # 일단 정렬시켜
    numbers.sort()
    
    answer = numbers[-1]*numbers[-2]
    return answer