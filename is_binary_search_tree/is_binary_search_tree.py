# https://app.codesignal.com/challenge/JxtKfByYCECLL24ed

# all credits go to @zero_cool :)
# 
# Definition for binary tree:
# class Tree(object):
#   def __init__(self, x):
#     self.value = x
#     self.left = None
#     self.right = None
def isBinarySearchTree(tree):
    def check(node,a=-1e9,b=1e9):
        v = node.value # node value
        
        if v < a or v > b:
            return False
        
        t = True
        if node.left:
            t &= check(node.left,a,v-1)
            
        if t and node.right:
            t &= check(node.right,v+1,b)
            
        return t
        
    
    # run
    return check(tree)
