# N, M 입력
n, m = map(int, input().split())

# 2차원 배열 입력받기(얼음틀)
iceMaker = []
for i in range(n):
    iceMaker.append(list(map(int, input())))

def dfs(x, y):
    # 범위 넘어가면 바로 false
    if x<=-1 or x>=n or y<=-1 or y>=m:
        return False
    
    # 아직 방문하지 않았으면
    if iceMaker[x][y]==0:
        # 현재 노드 방문 표시
        iceMaker[x][y]=1
        # 상하좌우도 재귀함수로 방문 확인 후 표시
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False

# 얼음틀에 음료수 넣기
cnt = 0    # 얼린 음료수 개수
for i in range(n):
    for j in range(m):
        if dfs(i, j)==True:
            cnt+=1
print(f"음료수 개수 : {cnt}")