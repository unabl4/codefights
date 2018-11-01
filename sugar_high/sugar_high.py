# https://app.codesignal.com/challenge/dY34cRWCf9Jo7XWqb

def sugarHigh(c,t):
    i = range(len(c))
    z = sorted(i,key=lambda k: c[k])
    j = 0
    p = []
    while j < len(z) and t-c[z[j]] >= 0:
        t -= c[z[j]]
        p.append(z[j])
        j += 1
    
    return sorted(p)
