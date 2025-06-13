import sys
sys.setrecursionlimit(10**6)

a, b, c = map(int, input().split())
# 단순하게 하면 시간 초과 => 모듈러 연산을 해줘야 함

# 재귀를 통해 구현
def power(a,b,c):
    if(b==0): return 1  # b가 0이면 1

    half = power(a,b//2,c)
    res = (half*half)%c

    # b가 홀수일 경우엔 (a%c) 더 곱해줌
    if(b%2==1):
        return (res*(a%c))%c
    return res

print(power(a,b,c))