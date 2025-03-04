def solution(number, n, m):
    # number를 n, m으로 나눴을 때 둘 다 나머지가 0이면 공배수
    if(number%n==0 and number%m==0):
        return 1
    return 0