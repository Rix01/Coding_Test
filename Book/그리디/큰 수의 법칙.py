# # N, M, K 공백으로 나눠서 받기
# N, M, K = map(int, input().split())

# Narr = list(map(int, input().split()))

# # 역으로 정렬
# Narr.sort(reverse=True)

# answer = 0
# cnt = 0
# idx = 0
# for i in range(M):
#     if idx==0 and cnt == K:
#         idx = 1
#         cnt = 0
    
#     elif idx!=0:
#         idx = 0
#         cnt = 0
    
#     answer += Narr[idx]
#     cnt += 1

# print(answer)
# 위는 초기 내 풀이

# 아래는 좀 더 효율적인 방법
# 반복되는 수열을 파악해서 풀기
# 반복되는 수열의 길이는 K+1
# M을 K+1로 나눈 몫이 수열이 반복되는 횟수. 여기에 K를 곱하면 가장 큰 수가 등장하는 횟수
# 이때, 나누어 떨어지지 않는 경우도 고려해야함.
# M을  K+1로 나눈 나머지만큼 가장 큰 수가 추가로 더해지므로 이를 고려해줘야 함.
# 결과적으로 int(M//(K+1)) * K + M % (K+1) ==> 가장 큰 수가 추가로 더해지는 횟수

n, m, k = map(int, input().split())
n_arr = list(map(int, input().split()))

n_arr.sort(reverse=True)
# 가장 큰 수
first = n_arr[0]
# 2번째로 큰 수
second = n_arr[1]

# 가장 큰 수가 더해지는 횟수 계산
count = int(m//(k+1)) * k + m %(k+1)

result = 0
result += count * first # 가장 큰 수 더하기
result += (m-count) * second
print(result)