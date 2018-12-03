# https://app.codesignal.com/challenge/FydJQM2qks5LJYkeP

# I must say, that was one of the weirdest challenges I came across so far, despite the complexity. Ugh ... :) 
def detectBreakbeat(p):
    t = p.split()
    n = len(t)
    k = t[0] # the first sample
    
    # not possible
    if n < 8:
        return False
    
    # the first note must be a kick
    if k in ('~',''):
        return False # not a kick

    q = n // 4 # quarter length
    
    # part 1: snare/clap on 2nd and 4th quarters
    if t[q] != t[3*q] or t[q] in ('~','',k):
        return False
    
    # part 2: bass kick
    return any(t[i*(n//8)] == k for i in (3,5))
            
# 0 1 2 3 4 5 6 7 (len = power of 2)
# 1 1 2 2 3 3 4 4
#     x y     x y
# f 
# 
# 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 (len=16)
# 1 1 1 1 2 2 2 2 3 3 3  3  4  4  4  4
# 
# 0 1 2 3 (len=4)
# 1 2 3 4
