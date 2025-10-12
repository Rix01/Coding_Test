
n, m = map(int, input().split())
lectures = list(map(int, input().split()))

# 강의 합
lecture_hap = sum(lectures)
start = lecture_hap // m
end = lecture_hap
max_size = 0
i = 0
while start <= end:
    if i == 0:
        mid = start
        i += 1  # do while문처럼 처음에만

    else:
        mid = (start + end) // 2

    # mid 넘지 않는만큼 묶음
    packages = []
    hap = 0
    for i in range(n-1):
        now = lectures[i]
        next_lec = lectures[i+1]

        hap += now

        if (hap + next_lec) <= mid:
            continue
        else:
            packages.append(hap)
            hap = 0
    # 마지막 강의는 따로 처리
    packages.append(hap+lectures[-1])
    hap = 0

    # {1: [1, 2, 3, 4, 5], 2: [6, 7], 3: [8], 4: [9]}
    # => 이렇게 저장보다 그냥 합 저장하는 게 나을 거 같아서 변경
    # [15, 13, 8, 9]

    # 일단 개수 먼저 확인
    # m보다 크면 start 옮김
    if m < len(packages):
        start = mid + 1
    # m보다 작거나 같으면 end 옮김
    else:
        end = mid - 1
        # packages 값 중 가장 큰 값을 max_size에
        max_size = max(packages)
print(max_size)
