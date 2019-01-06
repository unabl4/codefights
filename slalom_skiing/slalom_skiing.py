# https://app.codesignal.com/challenge/RLhyzdapSvfRXCHHd

def slalomSkiing(flags, threshold):    
    n = len(flags)
    mf=0 # max flag reached (1-based)
    for offset in (-1,1): # initial offset
        z=1 # offset switcher
        f=0 # current max flag (1-based), 0 = full course
        for i in range(n-1):
            s,e = flags[i:i+2] # start, end
            x=s+offset*z
            y=e+offset*-z
            d=abs(y-x) # distance
            if d > threshold:
                f=i+1
                break
            
            z*=-1 # flip (alternate)
        
        if f:
            mf=max(mf,f) # set/update
            continue
        
        # we have completed the course
        return -1
    
    return mf
