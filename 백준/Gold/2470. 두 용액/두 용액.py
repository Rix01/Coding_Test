n = int(input())
solution = list(map(int, input().split()))

# 용액 오름차순 정렬
solution.sort()

start = 0
end = len(solution)-1
min_num = float("inf")
result = []

while(start < end):
    hap = solution[start] + solution[end]

    if abs(hap) < min_num:
        min_num = abs(hap)
        result = [solution[start], solution[end]]

    if hap == 0:
        break

    elif hap > 0:
        end -=1

    elif hap < 0:
        start += 1

print(*result)