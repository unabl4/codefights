# https://app.codesignal.com/challenge/MmWaRGztxBCc9NDvR

# looks odd, but it works (I hope)
def christmasLargeFamiliesGifts(family1, family2):
    n = len(family1) # len
    v = [0] * n # vector (1 - f1 greater f2; -1 - opposite)
    for i in range(n):
        if family1[i] == family2[i]:
            continue # nothing
        v[i] = 1 if family1[i] > family2[i] else -1

    
    mo = v.count(-1)    
    s = 0
    for i in range(n):
        if v[i] == 1:
            s += mo
        elif v[i] == -1:
            mo -= 1
        
    return s
