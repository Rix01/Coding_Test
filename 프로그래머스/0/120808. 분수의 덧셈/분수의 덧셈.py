import math

def solution(numer1, denom1, numer2, denom2):
    # 일단 더해
    hap = [1]*2
    hap[0] = (numer1*denom2)+(numer2*denom1)
    hap[1] = (denom1*denom2)
    
    # 최대공약수로 나눠
    gcd = math.gcd(hap[0], hap[1])
    hap[0] = hap[0]//gcd
    hap[1] = hap[1]//gcd
    
    return hap