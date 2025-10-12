
n, m = map(int, input().split())
trees = list(map(int, input().split()))

# 1. 정렬
trees.sort()

# 2. 값으로 이분탐색
start = 0   # 절단기 높이는 0부터 가능하므로 0부터!!
end = trees[-1]
max_h = 0

while (start <= end):
    mid = (start + end) // 2

    left_tree = 0
    for tree in trees:
        if tree > mid:
            left_tree += tree - mid

    if left_tree >= m:
        max_h = mid
        start = mid + 1

    # m보다 작으면 더 작게 잘라야 하니까 end를 옮김
    elif left_tree < m:
        end = mid - 1

# 맨 앞에 있는 거의 2번째 값
print(max_h)