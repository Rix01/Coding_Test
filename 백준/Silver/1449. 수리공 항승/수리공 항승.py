n, l = map(int, input().split())
broke = list(map(int, input().split()))

# 일단 broke 정렬
broke.sort()
cnt = 0
cover = 0
for i in range(n):
    if broke[i]<=cover:
        continue
    cover = broke[i]+l-1
    cnt+=1

print(cnt)