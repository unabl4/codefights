# https://app.codesignal.com/challenge/W3nmGcuKzkg9AeEwo

def io(node, values=[]):
    # left
    if node.left:
        io(node.left,values)

    # current value
    values.append(node.value)
    
    # right
    if node.right:
        io(node.right,values)

    return values

def preo(node, values=[]):
    # current value
    values.append(node.value)
    
    # left
    if node.left:
        preo(node.left,values)
    
    # right
    if node.right:
        preo(node.right,values)

    return values

def posto(node, values=[]):
    # left
    if node.left:
        posto(node.left,values)
    
    # right
    if node.right:
        posto(node.right,values)
        
    # current value
    values.append(node.value)

    return values

# ---
# 
def betterOrderTraversal(root):
    v=[f(root) for f in [io,preo,posto]] # map
    return min(v)
