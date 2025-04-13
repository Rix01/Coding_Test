import math
def solution(n):
    m = math.sqrt(n)
    if(m.is_integer()):
        return 1
    return 2