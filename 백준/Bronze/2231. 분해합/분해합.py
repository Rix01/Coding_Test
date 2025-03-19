m = int(input())

flag = 0
for i in range(1, m+1):
    M = i
    # 몇자리 수인지 알아내기
    mLen = len(str(i))
    for j in range(1, mLen+1, 1):
        M += (i%(10**j))//(10**(j-1))
    
    if(M==m):
        print(i)
        flag =1
        break

if flag==0:
    print(0)