# https://app.codesignal.com/challenge/RNEKN3MFMDxGwHYab

def trafficLights1D(r):    
    t = 0 # time
    n = len(r)
    
    # distances between the traffic lights
    g = [r[0] for r in r]
    d = [i[1]-i[0] for i in zip(g[:-1], g[1:])]
    t = r[0][0] # initial time - time until the first light (1s = 1m)
    
    for i in range(n):
        l = r[i]
        j = t // l[1]
        if j % 2 == 1:
            # red -> wait
    
            # # next green time = total number of all the periods + the current (red) period
            w = j*l[1]+l[1]-t # wait time        
            t += w
            
        if i < n-1:
            t += d[i] # 1 meter per second
    
    return t
