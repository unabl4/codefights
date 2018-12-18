# https://app.codesignal.com/challenge/LLvSQBNDeLXqdksrX

def sleddingHills(enj, max_runs):
    n = len(enj)
    r = range(n)
    max_enj = 0
    while max_runs > 0:
        max_idx = max(r, key=lambda k: enj[k]) # select max
        if enj[max_idx] <= 0:
            break # won't find anything
        max_enj += enj[max_idx]
        enj[max_idx] -= 1
        max_runs -= 1
    
    return max_enj
