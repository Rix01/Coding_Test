'''
유제품 3개 사면
- 가장 싼 것 무료, 나머지 2개 가격 지불
- 3개 안 사면 다 정가 지불
'''

n = int(input())
items = []

for _ in range(n):
    items.append(int(input()))

# 정렬
items.sort(reverse=True)

# 3개씩 자르기
package = []
# 꾸러미 수
package_num = len(items) // 3 + 1

for i in range(package_num):
    package.append(items[i * 3 : (i + 1) * 3])

hap = 0
for items in package:
    if len(items) < 3:
        hap += sum(items)
    else:
        for i in range(0, 2):
            hap += items[i]

print(hap)
