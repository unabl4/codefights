# https://app.codesignal.com/challenge/tetzWm8AJsTGWgL9X

def speedingForCandy(s,n,k):
    w = len(s[0])
    def sp(h):
        ms = [0] * len(h) 
        ms[0] = h[0]
        for i in range(1,w): 
            ms[i] = max(h[i], ms[i-1]+h[i]) 
        
        r = z = sum(h[:n])
        for i in range(n,w):
            z = z+h[i]-h[i-n] 
            r = max(r, z) 
            r = max(r, z+ms[i-n]) 

        return r

    # ---
    
    v = [sp(h) for h in s]
    v = sorted(v,reverse=True)
    ms = 0
    for i in range(k):
        ms = max(ms, ms+v[i])
        
    return ms
