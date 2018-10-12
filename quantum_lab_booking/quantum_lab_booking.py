# https://app.codesignal.com/challenge/iWBemn2LDkBokcR6h

from collections import deque
def quantumLabBooking(friends, firstInLine, k):
    q = deque([firstInLine]) # queue
    v = [firstInLine]
    
    while q:
        if len(v) > k:
            break
        
        f = q.popleft() # current friend visiting the lab
        for a,b in enumerate(friends[f]):
            if b:
                v.append(a)
                q.append(a)
    
    return v[k] if k < len(v) else -1
