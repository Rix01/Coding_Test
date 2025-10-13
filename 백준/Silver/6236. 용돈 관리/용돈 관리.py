n, m = map(int, input().split())
use_money = []
for _ in range(n):
    use_money.append(int(input()))

start = max(use_money)
end = sum(use_money)
min_k = 0
while start <= end:
    mid = (start + end) // 2
    cnt = 1
    k = mid
    # use_money 돌면서 cnt 카운트
    for money in use_money:
        if money <= k:
            k -= money
        else:
            cnt += 1
            k = mid - money

    if cnt <= m:
        end = mid - 1
        min_k = mid
    else:
        start = mid + 1

print(min_k)