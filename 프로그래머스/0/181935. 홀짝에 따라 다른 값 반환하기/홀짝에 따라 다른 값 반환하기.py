def solution(n):
    answer = 0
    # n이 홀수라면
    if(n%2==1):
        for i in range(1,n+1,2):
            answer += i
    # 짝수라면
    else:
        for i in range(2, n+1, 2):
            answer += i**2
    return answer