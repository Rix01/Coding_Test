n = int(input())
m = int(input())

seat = [0] * n
for _ in range(m):
    vip_seat_idx = int(input())
    seat[vip_seat_idx-1] = 1

section = []
## vip_seat 기준으로 덩어리 구역 나누기
count = 0
for i in range(n):
    if seat[i] != 1:
        count += 1
    elif seat[i] == 1:
        section.append(count)
        count = 0
    # 맨 마지막
    if i == n-1:
        section.append(count)

# 덩어리의 크기만큼 경우의 수
dp = [1, 1]
for i in range(2, n+1):
    dp.append(dp[i-1] + dp[i-2])

# 덩어리 돌면서 곱해줌
result = 1

for sec in section:
    result *= dp[sec]

print(result)