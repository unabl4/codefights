# https://app.codesignal.com/challenge/k9Gq2RwiHJbWFK6dG

# that was darn fun doing it in last hour :)
def snowflakeCrafts(pattern):
    # algorithm:
    # step 1: unfold diagonally
    # step 2: unfold left
    # step 3: unfold down
    
    # ---
    
    n = len(pattern[0])
    g = [[' ' for _ in range(n)] for _ in range(n)] # initial grid
    for y in range(n):
        for x in range(n-y):
            g[y][x] = pattern[y][x]
    
    # step 1: unfold diagonally
    for y in range(1,n):
        for x in range(n-y,n):
            g[y][x] = g[n-x-1][n-y-1] # copy over

    # step 2: unfold left
    # take last N-1 columns, flip vertically
    
    for y in range(n): # row-wise
        g[y] = g[y][:0:-1] + g[y]
    
    # step 3: unfold down
    g = g[:-1] + g[::-1]
    
    return [''.join(r) for r in g]
