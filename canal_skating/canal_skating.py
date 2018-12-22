# https://app.codesignal.com/challenge/oH9RwPTGeHuqo2FJs

cp = set([200,1400,3250,7000]) # m; check points (beavertail stands)
t = [-1,8,5,3,2,1] # s; time

MAX_LEN = 7801

def canalSkating(c,sp):
    # step 1: "draw" the entire rink from 0 to 7800 (inclusive)
    # that can be done with the "two-pointer" approach (I guess)
    # if the second pointer is out of range -> take the MAX VAL (7800)
    # 
    # step 2: depending on the starting point (sp) traverse in either one or two 
    # directions
    # 
    # step 3: return the min time; if no min time obtained -> return -1 as unreachable

    # ---
    
    r = [-1 for _ in range(7801)]
    n = len(c) # number of conditions
    i,j = 0,1
    while True:
        # there's at least one condition!
        v1 = c[i][0] # start
        v2 = c[j][0] if j < n else MAX_LEN
        
        for z in range(v1,v2): # exclusive range
            r[z] = t[c[i][1]]
    
        if j >= n:
            # we have reached the end -> stop the process
            break
        else:
            # move right
            i = j
            j += 1
    
    # ---
    
    ml = mr = -1 # min left and min right
    if sp >= 200:
        ml = 0 # reset
        i = sp
        while True:
            if r[i] == -1: # not possible?
                ml = -1
                break
            
            ml += r[i]
            if i in cp:
                break
    
            i -= 1 # move left
            
    # move right
    if sp <= 7000:
        mr = 0
        i = sp
        while True:
            if r[i] == -1: # not possible?
                mr = -1
                break
            
            mr += r[i]
            if i in cp:
                break
    
            i += 1 # move right
    # ---
    
    m = max(ml,mr)
    for mv in [ml,mr]:   
        if mv != -1:
            m = min(m,mv)
    
    return m
