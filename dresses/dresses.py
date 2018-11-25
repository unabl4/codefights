# https://app.codesignal.com/challenge/t8kHRFHTh4GKBCKSN

def dresses(c):
    n = len(c)
    t = []
    for i in range(n):
        s = c[i]
        r,g,b = [int(s[j:j+2],16) for j in range(0,6,2)] # parse
        if g > r and g > b:
            t.append(i)
        
    return t
