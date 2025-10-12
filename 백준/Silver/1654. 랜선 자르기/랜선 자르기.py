k, n = map(int, input().split())
lan_cables = []
for _ in range(k):
    lan_cables.append(int(input()))

# 랜선 다 더한 값 // n가 end 값
start = 1
end = sum(lan_cables) // n
max_length = 0
i = 0
while start <= end:
    if i == 0:
        mid = end
        i += 1  # 맨 처음만을 위함
    else:
        mid = (start + end) // 2

    # 해당 길이로 만들 수 있는 케이블 구하기
    make_count = 0
    for lan_cable in lan_cables:
        make_count += (lan_cable) // mid

    # 크거나 같으면 더 크게 잘라야 함 (start를 옮김)
    if make_count >= n:
        max_length = mid
        start = mid + 1

    # 작으면 더 작게 잘라야 함 (end를 옮김)
    else:
        end = mid - 1

print(max_length)