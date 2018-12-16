# https://app.codesignal.com/challenge/Cfwd7gTQcNyTejNtf

def matrixToDecimal(m):
    w = len(m[0])
    h = len(m)
    g = None
    # finding the decimal point column index
    for c in range(w):
        if m[2][c] == '.':
            g = c
            break
    
    num = 0
    for c in range(w): # column
        mult = 10**(g-c) # multiplier: 10^(x)
        h = 5 if m[1][c] == 'o' else 0 # top part (reset)
        r = 3 # starting from the third row (middle section)
        while m[r][c] == 'o':
            h += 1
            r += 1 # move down
        
        num += h * mult
            
    return num
