# https://app.codesignal.com/challenge/uhEJTTKzo6qMwTawf

def christmasSquareBoxes(boxes):
    f = {} # freq size -> occ
    
    for b in boxes:
        f[b] = f.get(b,0)+1
        
    return max(f.values())
