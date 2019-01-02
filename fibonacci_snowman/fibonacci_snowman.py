# https://app.codesignal.com/challenge/FkppNT5CtbmZgHLuP

F = [1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946]

# ---
    
def fibonacciSnowman(n,k):   
    # part 1: https://www.geeksforgeeks.org/fibonacci-coding/
    i = 0
    while True:
        if F[i] <= n and F[i+1] > n:
            break
        i += 1
        
    # ---
    
    v = [0] * (i+1)
    
    while n: 
        v[i] = 1
        n -= F[i]
        i -= 1
        
        while i >= 0 and F[i] > n:
            v[i] = 0
            i -= 1
    
    # ---
    # From the description of the Fibonacci Coding algorithm (used in this solution) we know that it generates 
    # the SHORTEST representation (sum of Fibonacci numbers) of any given positive natural number N;
    # 
    # Now comes the most important part (what this challenge is mostly about, I think)
    # Since Fibonacci sequence elements (by definition) are the SUM of the previous two F-elements, we can utilize it for our advantage
    # to increase the length of the sequence (our goal is K) summing to N;
    # In other words, every time we "expand" an F-element, we increase the total length by 1 (the sum remains the same)
    # In our case we will be iteratively finding a leftmost F-element greater than 1 (we cannot expand 1) and expanding it.
    
    o = v.count(1) # number of occupied F-elements (must in the end equal to K)
    while o != k: 
        z = -1 # index of the F-element to be expanded into sum of two F-elements
        for j in range(1,len(v)):
            if v[j] != 0:
                z = j
                break
                
                
        if z == 1:
            # special case for two
            v[z-1] += 2
            v[z] -= 1
        else:
            v[z-2] += 1
            v[z-1] += 1
            v[z] -= 1
                
        o += 1

    # ---
        
    r = [] # resulting vector
    for t in range(len(v)):
        r += [F[t]] * v[t]
    
    return r
