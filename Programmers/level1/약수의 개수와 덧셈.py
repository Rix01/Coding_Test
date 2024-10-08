# 효율적으로 약수를 찾는 알고리즘
# https://kbw1101.tistory.com/32#2.%20%ED%9A%A8%EC%9C%A8%EC%A0%81%EC%9C%BC%EB%A1%9C%20%EC%95%BD%EC%88%98%EB%A5%BC%20%EC%B0%BE%EB%8A%94%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
# "N의 약수를 구할 때는, 1부터 N의 제곱근 까지의 수만 0으로 나누어 떨어지는지 확인하면 된다!
# 이후, N을 그 수들로 나눈다.
# 중복 제거 후 오름차순 정렬을 하면 N의 약수를 모두 구할 수 있음.

import math

def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        arr_n = []  # 약수 담을 배열
        sqrt_i = int(math.sqrt(i))
        for j in range(1, sqrt_i+1):
            if(i%j==0):
                arr_n.append(j)
                # 25 = 5*5와 같은 상황일 때는 하나만 넣어주기 위해 조건문 하나 추가
                if((j**2) != i):
                    arr_n.append(i//j)
        cnt = len(arr_n)    # 약수 개수
        if(cnt%2==0):   # 짝수라면
            answer += i
        else:
            answer -= i
    return answer