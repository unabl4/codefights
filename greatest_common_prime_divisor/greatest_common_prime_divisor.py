# https://app.codesignal.com/challenge/2S8ZobHRrpmFn4TiC

def is_prime(n):
    for i in range(2,int(n**0.5)+1):
        if n % i == 0:
            return False
    
    return True

def greatestCommonPrimeDivisor(a, b):
    v = [i for i in range(2,150) if is_prime(i) and a % i == 0 and b % i == 0]        
    return max(v) if v else -1
