# https://app.codesignal.com/challenge/D7xcKDseTa2gLondg

# [h,a,r] - health/attack/resistance
v = { 'a': [5,6,2], 'b': [6,8,2], 'g': [8,6,5] }
def masterVsFighters(f,m):
    n = c = len(f) # fighters alive counter
    fs = [v[i].copy() for i in f] # convert to fighter descriptors (~map)
    # 'copy' is important not to link to the same dictionary array object
    
    i = 0 # fighter index
    t = 0 # turn (0 - fighter, 1 - master)
    
    stat = [0] * 8
    
    # while either the master and at least one fighter are alive -> carry on
    while c > 0 and m[0] > 0:
        cf = fs[i] # current fighter
        if cf[0] <= 0:
            # the fighter is dead
            t = 0  # reset (fighter attacks first)
            c -= 1 # decrement the counter
            i = (i+1) % n # move on to the next fighter
            continue
    
        # select source and target
        s = cf
        d = m
        if t == 1: # master's attack
            s = m
            d = cf
        
        dmg = max(0,s[1]-d[2])
        d[0] -= dmg # attacker's attack minus (paranoid)
        stat[4+t] += 1 # number of hits
        stat[6+t] = ((stat[6+t] * (stat[4+t]-1)) + dmg) / stat[4+t] # avg dmg (per hit)
        t = (t+1) % 2 # change turn
    
    # define the winner
    stat[0] = 'Master' if c <= 0 else 'Fighters'
    stat[1] = n-c
    stat[2] = c
    stat[3] = max(0,m[0])
    
    return [str(s) for s in stat[:6]] + ['%.2f' % round(i,2) for i in stat[6:]]
