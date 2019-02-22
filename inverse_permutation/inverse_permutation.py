# https://app.codesignal.com/challenge/A674cE5ibcAEabYZn

def inversePermutation(p):
    n = len(p)
    m = { p[k]:(k+1) for k in range(n) }
    return [m[i] for i in range(1,n+1)]
