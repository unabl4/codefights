# https://app.codesignal.com/challenge/CRKQyszeHnwmpkkxW

from collections import deque as d
def expandMinesweeper(field, click_row, click_column):
    # return the field as-is if the clicked cell is NOT empty
    if field[click_row][click_column] != 0:
        return field
    
    # dim
    w = len(field[0])
    h = len(field)
    
    # typical bfs
    q = d([[click_row, click_column]])
    v = set() # visited nodes
    
    while q:
        y,x = q.popleft() # and not pop(0) for lists
        v.add((y,x)) # mark as visited
        
        field[y][x] = -2 # modify
        
        for dy in range(-1,2):
            for dx in range(-1,2):
                # new coordinates
                ny = y+dy
                nx = x+dx

                if ny < 0 or ny >= h or nx < 0 or nx >= w or (ny,nx) in v or field[ny][nx] != 0:
                    continue
    
                v.add((ny,nx))
                q.append((ny,nx)) # next node to visit            
    
    # return the new field
    return field
