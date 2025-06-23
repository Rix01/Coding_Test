import sys
input = sys.stdin.readline

n, k = map(int, input().split())
temp = [0]  # 0번째 인덱스
temps = list(map(int, input().split()))
temp = temp + temps

prefix_sum = [0]
# 누적합 구하기
for i in range(1, n+1):
    prefix_sum.append(prefix_sum[i-1] + temp[i])

k_sum = []
# k에 따른 연속적인 합 구하기
for i in range(k, n+1):
    k_sum.append(prefix_sum[i] - prefix_sum[i - k])

# 최대값 구하기
print(max(k_sum))