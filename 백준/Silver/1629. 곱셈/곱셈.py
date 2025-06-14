def power_iter(a, b, c):
    result = 1
    a = a % c  # 처음부터 모듈러 연산 적용

    while b > 0:
        if b % 2 == 1:        # b가 홀수일 경우
            result = (result * a) % c
        a = (a * a) % c       # a 제곱
        b = b // 2            # b 절반

    return result

a, b, c = map(int, input().split())
print(power_iter(a,b,c))