# https://app.codesignal.com/challenge/Hd8f7gmnfa7HzXjbN

def equitableMeetup(r):
    n = len(r)
    totals = [i[0] for i in r] # at least one house is visited
    houses = [1] * n # number of visited houses counters for each friend
    best = houses.copy() # copy is important
    best_spread = max(totals)-min(totals) # initial spread
    
    while True:
        m = -1 # min
        
        # select the friend with the lowest number of candies
        for i in range(n):
            if houses[i] < len(r[i]) and (m == -1 or totals[i] < totals[m]):
                m = i 

        if m == -1:
            break
        
        # go to the next house
        totals[m] += r[m][houses[m]]
        houses[m] += 1
        
        # re-calculate the spread and see if it is any better now
        spread = max(totals)-min(totals)
        if spread < best_spread:
            best_spread = spread
            best = houses.copy() # copy is important
            
    return best
