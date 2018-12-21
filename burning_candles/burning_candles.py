# https://app.codesignal.com/challenge/jPjWP6EAqKStosvve

import heapq as hq

def burningCandles(c,n):
    if len(c) <= 0:
        return 0
    
    # max heap construction
    c = [-c for c in c]
    hq.heapify(c) 
    
    w = t = 0 # wax size, wax counter
    z = 0 # total sum
    while len(c):
        v = -hq.heappop(c)
        z += v
        
        w += v
        t += 1
        if t >= n: # we have burned enough candles to form a new candle
            hq.heappush(c, -(w//(n+1))) # add a new candle size value
            t = w = 0 # reset
    
    return z
