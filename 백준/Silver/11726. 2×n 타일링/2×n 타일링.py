n = int(input())
tiles = [0]*1001

tiles[1] = 1
tiles[2] = 2

def tiling(n):
    if n<=2:
        return tiles[n]
    else:
        for i in range(3, n+1):
            tiles[i] = tiles[i-1] + tiles[i-2]
        
        return tiles[n]

print(tiling(n)%10007)