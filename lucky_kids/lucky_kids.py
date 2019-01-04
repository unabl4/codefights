# https://app.codesignal.com/challenge/byJQfxnzSyQo3J5ED

from bisect import insort as I
def luckyKids(b):
    # not entirely sure what is so 'hard' about this challenge
    # behaving better than at least half means having a behaviour STRICTLY GREATER than the MEDIAN
    # MEDIAN = the middle value of a SORTED (asc) array; 
    # so to solve this we can run a running median  
    
    c = 1 # at least one child (the eldest) will get a gift
    n = len(b)
    v = [] # median array storage
    l = 0 # median array storage length
    for i in range(n-1):
        j = n-2-i
        I(v,b[j+1]) # add the element
        l += 1 # median storage length
        
        if l % 2 == 0:
            c += v[(l//2)-1] < b[j] <= v[l//2] or v[l//2] < b[j]
        else:
            c += v[l//2] < b[j]
    
    return c
