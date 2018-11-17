# https://app.codesignal.com/challenge/BEjXFgMYRt5435RyL

# even though I watched the stream (hello, @zero_cool), I decided to use the 'two-heap' approach instead;
# I like to live dangerously; heaps, here I come :)
import heapq as h
def medianScores(s):
    v = [0] * len(s)
    min_h = []
    max_h = []

    m = 0 # current median
    for i,n in enumerate(s):
        # insert the num into correct heap (min/max)
        if n > m:
            # goes to the min heap (right)
            h.heappush(min_h, n)
        else:
            # goes to the max heap (left)
            # since we do not have native max heap, we utilize min heap with negated numbers
            h.heappush(max_h, -n)
            
        # rebalance (very important)
        if len(min_h) > len(max_h) + 1:
            # if min heap size is more than 1 element bigger than the max heap ->
            # extract the min from the min heap and move it over to the max heap
            
            t = h.heappop(min_h) # the value
            h.heappush(max_h, -t) # insert inverted
        elif len(max_h) > len(min_h) + 1:
            # if min heap size is more than 1 element bigger than the max heap ->
            # extract the min from the min heap and move it over to the max heap

            t = h.heappop(max_h) # the value
            h.heappush(min_h, -t) # insert inverted
            
        # get the new median value
        if len(min_h) > len(max_h):
            # if the min heap size is greater -> the median is at the top of the min heap
            m = min_h[0]
        elif len(min_h) < len(max_h):
            # if the max heap size is grater -> the median is at the top of the max heap
            m = -max_h[0]
        else: 
            # if the sizes of the heaps are equal, the median is a combined value of both
            m = -(-(min_h[0]-max_h[0])//2) # look ma, 'ceil' without the math lib  
        
        v[i] = m # add the median to the result vector
            
    return v
