# https://app.codesignal.com/challenge/8iaWYohmsQWxhsxcD

# thank you, @zero_cool - wouldn't have solved it without you.
# I almost immediately figured it that the challenge consists of two parts, 
# but I had difficulties "formalizing" the first one to get all the changes.
# judging by the number of accepted solutions, this challenge is not of 'medium' 
# difficulty after all (closer to "hard" then)
# ---
# do not feel that this is well deserved from my side
# shouldn't have submitted, I guess
# yet again, all credits go to @zero_cool

def waysToReceiveChange(coins, item_price):
    #   1) need to obtain all possible changes
    #   2) for changes=0 there is only one (1) way to do it

    m = 1e9+7 # modulo
    def changes(amount,i=len(coins)-1,ch=set(), m=set()):
        h = i * 1e9 + amount # some clever magic
        if h in m: # memoized?
            return ch
        
        if amount <= 0:
            # we've paid the total amount (or overpayed)
            ch.add(-amount) # change
            return ch
    
        v = coins[i] # coin value
        
        # 2 paths:
        changes(amount-v,i,ch) # take the coin
        # do not take the coin; move on to the next one
        if i > 0:
            changes(amount,i-1,ch)
        
        m.add(h)
        return ch
    
    # get changes
    ch = changes(item_price)    
    max_change = max(ch) # max change
    chw = [0] * (max_change+1) # change ways vector
    chw[0] = 1 # there is one way to give no change (=0)

    # https://www.geeksforgeeks.org/coin-change-dp-7/
    for i in range(len(coins)): # coins
        for j in range(coins[i],max_change+1): # changes
            chw[j] = (chw[j] + chw[j-coins[i]]) % m
            
    return sum((chw[i] % m) for i in ch) % m
