def solution(n, lost, reserve):
    # 일단 맨 처음에는 다 있다고 가정하고 학생 수 만큼 배열 만들기
    students = [1]*(n+1)

    # lost와 reserve 모두 오름차순 정렬로 되어있다고 가정
    lost.sort()
    reserve.sort()

    # lost 통해서 도난당한 학생들 값 -1
    for idx in lost:
        students[idx] -= 1

    # 여벌 옷 가져온 학생들 값 +1
    for idx in reserve:
        students[idx] += 1

    # 앞에서부터 순차 탐색하면서 도난당한 사람이 나타났을 때, 앞 or 뒤 사람이 여벌 체육복이 있으면 주기
    # 앞 사람이 먼저 주는 걸로!
    for idx in lost:
        pre_idx = idx-1
        next_idx = idx+1

        if(students[idx]==0):
            if(students[pre_idx]==2):
                students[idx] = 1   # 앞 사람이 빌려줌
                students[pre_idx] -= 1  # 빌려주기 때문에 줄어듦
                continue    # 이미 빌렸으므로 다음으로
            elif(next_idx<=n and students[next_idx]==2): # 뒷 사람이 빌려줌
                students[idx] = 1
                students[next_idx] -= 1

    # 돌면서 탐색
    cnt = 0
    for hasUni in range(1, n+1):
        if students[hasUni] >= 1:
            cnt += 1

    # print(students)

    return cnt