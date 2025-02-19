n = int(input())
n_array = list(map(int, input().split()))

m = int(input())
m_array = list(map(int, input().split()))

# 일단 정렬
n_array.sort()

def check(array, target, start, end):
    if start>end:
        return "no"
    mid = (start+end)//2
    if(array[mid]==target):
        return "yes"
    elif(array[mid]>target):
        return check(array, target, start, mid-1)
    elif(array[mid]<target):
        return check(array, target, mid+1, end)

for i in m_array:
    result = check(n_array, i, 0, n-1)
    print(result, end=' ')