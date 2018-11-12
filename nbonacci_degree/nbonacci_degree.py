# https://app.codesignal.com/challenge/2ZSQqGx9H686fZ7if

def nbonacciDegree(s):
    # all numbers are zero
    if all(x == 0 for x in s):
        return 0
    
    # only one number
    if len(set(s)) == 1:
        return 1
    
    # ---

    n = len(s)
    
    # prefix sum
    ps = [0] * (n+1) 
    ps[0] = 0
    for i in range(1,n+1):
        ps[i] = ps[i-1]+s[i-1]
        
    # print([0] + s)
    # print(ps)
    
    # ---
    
    for i in range(n-1):
        l = n-i-1 # len
        if ps[n-1]-ps[i] == s[-1] and ps[l] == s[l]: # lamest confirmation ever ¯\_(ツ)_/¯
            return l
    
    return -1 # not possible (k, tnx, bye)
