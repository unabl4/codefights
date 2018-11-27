# https://app.codesignal.com/challenge/osYbsFapbE2c3rZsx

class Tree:
    def __init__(self, v):
        self.value = v
        self.left  = None
        self.right = None

    # ---
        
    def insert(self, value, level=1):
        if value < self.value:
            # insert to the left
            
            if self.left:
                # there is already something -> recursion
                return self.left.insert(value, level+1)
            else:
                # there is nothing yet -> spot found
                self.left = Tree(value)
                return level+1
        else: # >= 
            # insert to the right
            
            if self.right:
                # there is already something -> recursion
                return self.right.insert(value, level+1)
            else:
                # spot found
                self.right = Tree(value)
                return level+1
            
        
def heightOfBST(values):
    if len(values) <= 0:
        return 0
    
    level = 1 # global level
    tree = Tree(values[0]) # initialize the root node (height = 1)
    for v in values[1:]:
        level = max(level, tree.insert(v))
    
    return level
