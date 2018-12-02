# https://app.codesignal.com/challenge/ZGBMLJXrFfomwYiPs

# get the number of divisors
# O(sqrt(n))
def divisors(n):
    c = d = 0
    # for i in range(1,int(n**0.5)+1):
    i = 1
    while i**2 <= n:
        if n % i == 0:
            if n / i == i:
                # border number - to be accounted separately
                d += 1
            else:
                c += 1
        
        i += 1
    return 2*c+d

# powerset to generate all subsets of a given set: ~ O(2^n)
# considering the upper-limit constraint = 10, shouldn't be more than ~1024 subsets
def ps(s):
    n = len(s)
    v = set() # sum sets
    for i in range(1,1 << n): # avoid empty sub-sets
        z = 0 # subset sum
        for j in range(n): # items
            if i & (1 << j):
                z += s[j]
        v.add(z)

    return v
        
# main
def kinderLevon(b):
    md = mc = 0 # max divisors/candies
    for i in ps(b):
        d = divisors(i) # get the number of divisors
        if d > md or (d == md and i < mc):
            md = d
            mc = i
    
    return mc
