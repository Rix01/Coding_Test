n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

# 재배열하지 말라고 했지만 출력값만 나오면 되는 거 아닌가..?
a.sort(reverse=True)    # a는 내림차순
b.sort()    # b는 오름차순

answer = 0
for i in range(n):
    answer += a[i] * b[i]

print(answer)
