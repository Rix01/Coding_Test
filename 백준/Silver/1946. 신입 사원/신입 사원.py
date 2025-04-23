import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    # 지원자 목록
    apply = []
    n = int(input())

    for i in range(n):
        apply.append(list(map(int, input().split())))

    # 오름차순 정렬(서류 기준)
    apply.sort()

    cnt = 1 # 면접 1등 무조건 선발
    # for문 돌면서 계속 갱신 될 현재까지 중 가장 높은 순위
    best_interview = apply[0][1] # 처음은 서류 1등의 면접 순위

    for i in range(1, n):
        if(apply[i][1]<best_interview): # best_interview 보다 낮으면 생존
            cnt += 1
            best_interview = apply[i][1]

    print(cnt)