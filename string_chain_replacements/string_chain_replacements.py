# https://app.codesignal.com/challenge/ZFpmAs8w74eHvoHbA

def stringChainReplacements(s):
    c = 0 # counter    
    n = len(s) # len
    if n <= 1:
        return 0 # no changes possible
    
    i,j = 0,1 # word pointers
    f = {} # freq dictionary
    while j < n:
        if len(s[i]) > 1 and len(s[j]) > 1:
            # regular, easy case
            c += s[i][-1] != s[j][0]
            
            i += 1
            j += 1
        else:
            # not so easy case
            f[s[i][-1]] = 1
            
            # continue collecting single-char
            while j+1 < n and len(s[j]) <= 1:
                f[s[j][0]] = f.get(s[j][0], 0) + 1 # increment
                j += 1
                
            f[s[j][0]] = f.get(s[j][0],0)+1 # increment
            c += (j-i+1)-max(f.values())
            f.clear() # done
            
            # move on
            i = j
            j += 1
            
    return c
