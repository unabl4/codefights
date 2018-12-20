# https://app.codesignal.com/challenge/QbAFyBmzZec3aD6EZ

def whereToGather(travel_costs):
    h = len(travel_costs)
    w = len(travel_costs[0])
    
    min_gather_sum = -1
    for c in range(w): # columns
        values = [travel_costs[r][c] for r in range(h)]
        valid = 1
        for v in values:
            if v == -1: # not possibru :)
                valid = 0 # too sad there are no labeled loops in python
                break
        
        if not valid:
            continue
        
        gather_sum = sum(values)
        if min_gather_sum == -1 or gather_sum < min_gather_sum:
            min_gather_sum = gather_sum
    
    return min_gather_sum
