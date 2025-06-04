# 수 순서 바꾸기 X
# 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행
# 나눗셈은 정수 나눗셈. 즉, 몫만 취함.
# 음수를 양수로 나눌 때는 양수로 바꾸고 그 몫을 음수로 바꿈
import math
from itertools import permutations
import sys
input = sys.stdin.readline

n = int(input())
listA = list(map(int, input().split()))

# 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
calc = list(map(int, input().split()))

# 개수에 따라 연산자 리스트 만들기
ops = []
for i in range(4):
    if i==0:
        for j in range(calc[i]):
            ops.append("+")
    elif i==1:
        for j in range(calc[i]):
            ops.append("-")
    elif i==2:
        for j in range(calc[i]):
            ops.append("*")
    else:
        for j in range(calc[i]):
            ops.append("/")

# 중복 제거한 순열 생성
unique_perms = set(permutations(ops))

# 확인
# print(len(unique_perms))  # 출력: 60

def calculate(perm, listNum):
    idx = 0
    res = listNum[idx]
    for p in range(len(perm)):
        idx += 1
        if(perm[p]=="+"):
            res += listNum[idx]
        elif(perm[p]=="-"):
            res -= listNum[idx]
        elif(perm[p]=="*"):
            res *= listNum[idx]
        elif(perm[p]=="/"):
            if res < 0:
                res = -(-res // listNum[idx])
            else:
                res = res // listNum[idx]

    return res

max_result = -float('inf')
min_result = float('inf')

for pe in unique_perms:
    result = calculate(pe, listA)
    max_result = max(max_result, result)
    min_result = min(min_result, result)

print(max_result)
print(min_result)

