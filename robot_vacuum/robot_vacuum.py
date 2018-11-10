# https://app.codesignal.com/challenge/LeN9rfnAaN4fw4v7H

def robotVacuum(room, maxDirt):
    pods = [0]*4 # 4 pods
    dirt = sum(sum(r) for r in room) # total amount of dirt
    w,h = len(room[0]), len(room)
    
    moves = 0
    y,x = [0,0] # top left corner
    dy,dx = [1,1] # down,right
    while dirt > 0:
        # collect the dust
        i=0
        for a,b in [(0,0),(0,1),(1,1),(1,0)]:
            v = min(maxDirt, room[y+a][x+b]) # dirt values
            dirt -= v # decrement the dust count
            pods[(i-moves)%4] += v
            room[y+a][x+b] -= v
            i+=1
        
        # make the next move
        if (dx == 1 and x+1 >= w-1) or (dx == -1 and x == 0):
            dx *= -1 # change direction
            
            if (dy == 1 and y+1 >= h-1) or (dy == -1 and y == 0):
                dy *= -1 # change direction
            
            y += dy
        else:
            x += dx
    
        moves += 1
    
    return pods
