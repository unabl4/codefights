# https://app.codesignal.com/challenge/we9iKLGLCQMdzEvW3

# like, holy shit

def TEFI(b):
    if len(b) <= 0:
        return [0,0,0,0]
    
    w = len(b[0])
    h = len(b)
    
    v = [0] * 4 # letters' counter
    visited = set() # visited coordinates
    for y in range(h):
        for x in range(w):
            if (y,x) in visited:
                continue # ignore the 'seen' content
                
            if b[y][x] == '*': # top left corner      
                # the idea is that no matter what the figure is - 
                # it always resolves to something,
                # and that 'something' in this case is the letter 'I' (in most cases)
                # in addition - no two 'letters' are overlapping or touching each other
                # so for every top-left corner of the letter, we need to find out, 
                # what the letter looks closer to
                                
                visited.add((y,x)) # mark the top left corner as visited
                
                cy,cx = y,x
                while cy+1 < h and b[cy+1][x] == '*':
                    visited.add((cy+1,x)) # mark vertical part as visited
                    cy += 1 # move down
                                
                if y == cy:
                    # there is NO vertical bar there -> it can only be 'T' (single point, if confirmed)                    
                    cx1 = cx # new variables are irritating, but oh well
                    while cx1+1 < w and b[cy][cx1+1] == '*':
                        visited.add((cy,cx1+1)) # mark as visited anyway
                        cx1 += 1
                    
                    if cx1 == x:
                        # no progress horizontally -> it can only be 'I' (single point)
                        v[3] += 1 # mark the letter
                    else:
                        # we've made some progress TO THE RIGHT
                        # -> we need to find 'x' such that y+1 == '*' (to find the middle part of T)
                        
                        cy2 = cy
                        cx3 = None
                        for cx2 in range(x,cx1+1):
                            # moving horizontally from X to CX+1
                            if cy2+1 < h and b[cy2+1][cx2] == '*':
                                # bingo, we found it
                                cx3 = cx2 # the middle point
                                break # found it
                        
                        if cx3 is None:
                            v[3] += (cx1-x+1)
                            continue
                        
                        cy3 = cy
                        while cy3+1 < h and b[cy3+1][cx3] == '*':
                            visited.add((cy3+1,cx3)) # mark it all as visited
                            cy3 += 1 # move down
                        
                        v[0] += 1 # mark as 'T'
                else:
                    # there IS a vertical bar -> right now we can consider it to be (I,E,F), not sure about T, though.
                    # need to traverse from top to bottom vertically and collect Y's where horizontal bars present and then do the analysis
                                      
                    ys = [0] * (cy-y+1) # total vector
                    for cy2 in range(y,cy+1):
                        cx2 = x # reset the 'X' coordinate
                        while cx2+1 < w and b[cy2][cx2+1] == '*':
                            visited.add((cy2,cx2+1)) # mark as visited
                            cx2 += 1 # move right
                            
                        if cx2 > x: # have we made any progress?
                            ys[cy2-y] = 1 # mark as WITH the horizonal bar
                    
                    z = sum(i==1 for i in ys) # count the number of horizontal bars
                    if z == 3: # first and last must be horizontal bars
                        # most likely it is 'E'
                        v[1] += 1
                    elif z == 2 and ys[0] == 1 and ys[-1] == 0: # not the last one?
                        # most likely it is 'F'
                        v[2] += 1
                    elif z == 0:
                        v[3] += 1 # must be 'I'
    # done
    return v
