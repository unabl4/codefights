# https://app.codesignal.com/challenge/qoF5KkByT3gDg4gjq

def isSkewSymmetricMatrix(m):
    n = len(m)
    
    if n == 1 and m[0][0] != 0:
        return False
    
    for r in range(n):
        for c in range(r+1):   
            if m[c][r] != -m[r][c]:
                return False
    
    return True
