# https://app.codesignal.com/challenge/3uWE2yHxBSBk2NGNF

def scariestMask(m):
    a = 0
    w = len(m[0])
    for r in m:
        a += sum(r[i] != r[w-i-1] for i in range(w//2))
        
    return a
