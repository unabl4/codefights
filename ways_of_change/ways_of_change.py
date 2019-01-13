# https://app.codesignal.com/challenge/yrBvLDnvJ7JC2svxj

import sys
sys.setrecursionlimit(1500) # not very fine tuned, but should be enough

def waysOfChange(amount):
    coins = [1,2,5,10]
    
    def inner(n,m,memo):
        if n == 0:
            return 1 
        
        if n < 0 or m <= 0:
            return 0 # no way
        
        if memo[n][m]:
            return memo[n][m]
        
        # 1) take the coin, 2) not take the coin
        v = inner(n-coins[m-1],m,memo)+inner(n,m-1,memo)
        memo[n][m] = v # remember the value
        return v
    
    m = len(coins)
    memo = [[None for _ in range(m+1)] for _ in range(amount+1)] # memoization table
    return inner(amount,m,memo)
