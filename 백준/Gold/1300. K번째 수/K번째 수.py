n = int(input())
k = int(input())

result = 0
start = 1
end = n * n
while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in range(1, n+1):
        cnt += min(n, mid//i)

    if cnt >= k:
        end = mid - 1
        result = mid
    else:
        start = mid + 1
print(result)