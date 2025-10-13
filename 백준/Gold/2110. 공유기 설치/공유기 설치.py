n, c = map(int, input().split())
home = []
for _ in range(n):
    home.append(int(input()))

# 정렬
home.sort()

start = 1
end = home[-1] - home[0]
max_distance = 0

while start <= end:
    mid = (start + end) // 2
    cur = home[0]
    cnt = 1

    for i in range(1, len(home)):
        # 거리가 mid 이상이면 공유기 설치 가능
        if home[i] - cur >= mid:
            cnt += 1
            cur = home[i]

    # c보다 크거나 같으면 start 옮김
    if cnt >= c:
        max_distance = mid
        start = mid + 1

    # c보다 작으면 end 옮김
    else:
        end = mid - 1

print(max_distance)