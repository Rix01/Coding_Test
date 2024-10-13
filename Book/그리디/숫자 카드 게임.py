# N과 M 입력받기
n, m = map(int, input().split())
# N*M 행렬 입력받기
nm_arr = []
min_arr = []

for i in range(n):
    nm_arr.append(map(int, input().split()))
    min_arr.append(min(nm_arr[i]))

# min_arr에서 제일 가장 큰 수
result = max(min_arr)

print(result)