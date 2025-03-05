n = int(input())
# 최소 봉지 개수 min_bag
minBag = 0

if n%5==0:
    print(n//5)

else:
    while(n>0):
        # 5로만 안 나누어지니까 3kg 하나 추가
        minBag += 1
        n -= 3
        # 3kg과 5kg 조합으로
        if(n%5==0):
            minBag += n//5
            print(minBag)
            break
        
        # 3kg 조합으로
        elif(n==3):
            minBag+=1
            print(minBag)
            break
        
        # 안 나누어짐
        elif(n==1 or n==2):
            print(-1)
            break