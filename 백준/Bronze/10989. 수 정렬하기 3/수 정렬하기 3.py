import sys

n = int(input())

# 입력받은 값 중 가장 큰 값 기준으로 리스트 생성
res = [0]*10001

# 리스트에 값 넣어주기
for i in range(n):
    inputN = int(sys.stdin.readline())
    res[inputN] += 1

# 출력
for r in range(len(res)):
    for c in range(res[r]):
        print(r)