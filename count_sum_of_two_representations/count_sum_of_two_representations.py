# https://app.codesignal.com/challenge/vkne85d6itCqRZmck

def countSumOfTwoRepresentations(n,l,r):
    return sum(sum(A+B==n for A in range(l,B+1)) for B in range(2,r+1))
