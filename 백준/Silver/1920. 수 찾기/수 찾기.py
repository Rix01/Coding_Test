n = int(input())
listN = list(map(int, input().split()))
m = int(input())
listM = list(map(int, input().split()))

# 정렬
listN.sort()

def binarySearch(list, start, end, target):
    if start > end:
        return 0

    mid = (start + end) // 2
    if list[mid] == target:
        return 1
    else:
        if list[mid] < target:
            return binarySearch(list, mid+1, end, target)
        elif list[mid] > target:
            return binarySearch(list, start, mid-1, target)

for i in range(m):
    print(binarySearch(listN, 0, n-1, listM[i]))


