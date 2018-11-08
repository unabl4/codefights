# https://app.codesignal.com/challenge/YzBvm6SRg9etKCNq6

def optimalRotatingBox(b,s):
    # calculate the SUM of each individual box coefficients
    # take a close attention to corner coefficients as they are counted twice
    # get all the nums from the box and sort them
    
    # get the box dimensions
    w,h = len(b[0]),len(b)
    
    p = w <= 1 or h <= 1 # special case
    # construct the coefficient vector (perimeter length)
    d = w*h if min(w,h) <= 1 else (w+h)*2-4 # dimensionality 
    c = [0] * d # coeff. vector
    
    i=0 # absolute index for the surface
    t=w # edge limit
    z=0 # edge counter
    r=0
    j=1 # direction for the special case
    for i in range(len(s)):
        c[z] += int(s[i])   # increment the corresponding coefficient
        if r==t-1: # edge limit reached
            # do NOT increment the counter (corner case)
            r=0
            t=h if t == w else w # update the target
            if p and z == d-1:
                # it is the end of the longest edge -> time to move back
                j = -1 # start going left
        else:
            if p and z == 0:
                j = 1   # start going right
            r += 1
            z += j
            z %= d
    
    # get the box numbers
    nums = []
    for r in b:
        for n in r:
            nums.append(int(n))
            
    num_pool = sorted(nums)
    return sum(a*b for a,b in zip(sorted(c, reverse=True), num_pool))
