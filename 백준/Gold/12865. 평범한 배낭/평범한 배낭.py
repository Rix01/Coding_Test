import sys
input = sys.stdin.readline

# 물품의 수 n, 준서가 버틸 수 있는 무게 k
n, k = map(int, input().split())
items = []

# 각 물건은 (w,v) 형태로 담긴다.
for i in range(n):
    items.append(tuple(map(int, input().split())))

# 무게에 따른 최대 가치
dp = [0] * (k+1)

# items에 있는 거 for문 돌리면서 체크
for w, v in items:
    for j in range(k, w-1, -1): # 이렇게 되면 k부터 시작해서 k, k-1, k-2, ..., w까지
        # 2가지 경우
        '''
        1. 물건을 선택함 => 무게 가능해야 함. 즉, 무게 확보 후 v 더하기
        2. 물건을 선택하지 않음 => 그대로
        '''
        dp[j] = max(dp[j], dp[j-w] + v)

print(dp[k])