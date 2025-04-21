# 이것도 BFS 문제인 것 같은디?
from collections import deque

queue = deque()

comNum = int(input())
connectNum = int(input())
connections = dict()

visited = [0]*(comNum+1) # 0번 없으니까

# 연결 정보 만들기
# {1: [2, 5], 2: [1, 3, 5], 3: [2], 5: [1, 2, 6], 6: [5], 4: [7], 7: [4]}
for i in range(connectNum):
    com1, com2 = map(int, input().split())
    if (com1 not in connections):
        connections[com1] = [com2]
    elif (com1 in connections):
        connections[com1].append(com2)

    if (com2 not in connections):
        connections[com2] = [com1]
    elif (com2 in connections):
        connections[com2].append(com1)
# print(connections)

# 1이랑 연결된 게 아무것도 없는 경우
if(1 not in connections):
    cnt = 0
else:
    queue.append(1)    # 1부터 시작
    visited[1] = 1
    cnt = 0
    while(len(queue)!=0):
        now = queue.popleft()

        # now의 원소 개수만큼 for문 반복
        for v in connections[now]:
            if visited[v] == 1: # 이미 방문했다면 pass
                continue
            else:
                cnt+=1
                visited[v] = 1
                queue.append(v)

print(cnt)