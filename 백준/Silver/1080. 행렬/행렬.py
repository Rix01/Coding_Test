# -1인 경우는
# 1. 3*3보다 배열이 작은데 다른 배열일 경우
# 2. 해보면서 끝까지 다 해봤는데 안 되는 경우.

# n: 행 m : 열
n, m = map(int, input().split())
a = []
b = []
for rows in range(n):
    a.append(list(map(int, input())))


for rows in range(n):
    b.append(list(map(int, input())))

def solution(n, m, a, b):
    # 3*3보다 배열이 작은데 다른 배열일 경우
    if (n < 3 or m < 3):
        if(a!=b):
            return -1

    # 시작도 전에 같은 배열이라면 print(0)
    if(a==b):
        return 0
    cnt = 0
    # 안 맞는 부분이 있다면 3*3 진행
    for r in range(n-2):
        for c in range(m-2):
            if(a[r][c]==b[r][c]):
                continue
            else:
                # 3*3 변환하기(이때, 범위 넘어가면 안 됨)
                flip3x3(a, r, c)
                cnt += 1

    if(a==b):
        return cnt
    return -1

def flip3x3(a, r, c):
    for row in range(r, r+3):
        for col in range(c, c+3):
            a[row][col] = 1 - a[row][col]

print(solution(n, m, a,b))