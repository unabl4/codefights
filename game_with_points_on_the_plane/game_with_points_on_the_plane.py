# https://app.codesignal.com/challenge/9ixLQDe5gHyiWSBXy

def gameWithPointsOnThePlane(pieces):
    n = len(pieces)    
    # distances from pieces to the origin (0,0)
    dists = [max(map(abs,p)) for p in pieces]
    
    for i,v in enumerate(sorted(dists)):
        if v-i <= 0: # distance goes to zero?
            return [] # not possible
    
    return sorted(range(n), key=lambda i: dists[i])


# 1 2 2 3 3 -> 1 1 2 2 -> 0 1 1 (Queen wins)
# 1 5 5 6 6 -> 4 4 5 5 -> 3 4 4 -> 3 3 -> 2 -> Gerda win 
# 7 8 9 -> 7 8 -> 7 -> Gerda win
# 1 1 1 1 1 -> 0 -> Queen wins
# 1 2 3 4 -> 1 2 3 -> 1 2 -> 1 -> Gerda wins
# 1 2 3 4 5 -> 1 2 3 4 -> 1 2 3 -> 1 2 -> 1 -> Gerda wins
# 1 2 3 4 4 -> 1 2 3 3 -> 1 2 2 -> 1 1 -> 0 -> Queen wins
# 1 1 2 5 5 -> 0 1 1 1 -> Queen wins
# 1 2 2 5 5 -> 1 1 4 4 -> 0 3 3 -> Queen wins
