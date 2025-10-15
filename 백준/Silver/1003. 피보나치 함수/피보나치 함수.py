t = int(input())

dp = [[1,0], [0,1]]

for i in range(2, 41):
    dp.append([dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]])

for _ in range(t):
    test_case = int(input())
    print(dp[test_case][0], dp[test_case][1])
