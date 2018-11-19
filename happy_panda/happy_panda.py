# https://app.codesignal.com/challenge/cEpnffZAHbeFQjqvC

def happyPanda(coins, candies):
    b = 0 # balance
    h = 0 # happiness
    u = 0
    
    for i in range(len(candies)):
        b += coins[i] # take
        p,t = candies[i] # price, tastiness
        if b >= p:
            # there's enough money to buy
            h += t
            b -= p # save the money
            u = max(u,t)
        else:
            # insufficient funds -> could not afford
            if t >= u:
                h -= t
                
    return h
