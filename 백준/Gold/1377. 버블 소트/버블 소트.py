import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    num = int(input())
    arr.append((num, i))    # 원래 인덱스도 함께 넣음
# 정렬
arr.sort()

max_distance = 0
for i in range(n):
    move_left = max(0, arr[i][1] - i)
    if(move_left > max_distance):
        max_distance = move_left

print(max_distance+1)
