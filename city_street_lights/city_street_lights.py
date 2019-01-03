# https://app.codesignal.com/challenge/QX7M66Hsu4k3ecdjS

def cityStreetLights(L):
    ml = l = 1 # len and max len; the minimum is still = 1
    n = len(L) 
    
    x,y = L[0],-1 # expectations
    i = 1 # start index
    while i < n:
        if y == -1:
            # setup mode
            
            # find a distinct contiguous pair
            while i < n and L[i] == L[i-1]:
                i += 1
            
            if i >= n:
                break # not found
            
            x,y = L[i-1],L[i] # set
            l = 2 # reset
        else:
            # regular interleaving comparison mode
            if L[i-1] == y and L[i] == x:
                x,y = y,x # swap the "expectations"
                l += 1 # increase the length
            else:
                y = -1 # go back into the "setup" mode
                continue
    
        i += 1
        ml = max(ml,l) # update the max length
    
    return ml # max length
