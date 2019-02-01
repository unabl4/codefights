# https://app.codesignal.com/challenge/6hgcY4YgsTW2GugT5

def maxFraction(n,d):
    return max(range(len(n)), key=lambda x:n[x]/d[x])
