# https://app.codesignal.com/challenge/ptsMnLDpgLRo3dbCB

# should be slightly faster than a naive string concatenation approach, but dunno
def lrSegmentNumber(l,r):
    # 3,4,5 => 3 * 10^2 + 4 * 10^1 + 5 * 10^0
    return sum(i * 10 ** (r-i) for i in range(l,r+1)) # 2,1,0
