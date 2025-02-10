n, k = map(int, input().split())

arrayA = list(map(int, input().split()))
arrayB = list(map(int, input().split()))

# A는 오름차순 B는 내림차순
upA = sorted(arrayA)
downB = sorted(arrayB, reverse=True)

# k번 바꿔치기
for i in range(k):
    if(upA[i]<downB[i]):
        upA[i], downB[i] = downB[i], upA[i]

print(sum(upA))