# https://app.codesignal.com/challenge/8QxWNh5tAFPBBPaqL

# terrible copycat
# O(1) warriors - I salute you
def chessBoardSquaresUnderQueenAttack(a,b):
    def explore(y,x,dy,dx):
        if y < 0 or y >= b or x < 0 or x >= a:
            return 0
        
        return explore(y+dy,x+dx,dy,dx)+1
    
    c = 0 # counter
    for y in range(b):
        for x in range(a):
            for dy in range(-1,2):
                for dx in range(-1,2):
                    if dy or dx:
                        c += explore(y+dy,x+dx,dy,dx)
    
    return c
