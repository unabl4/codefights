# https://app.codesignal.com/challenge/MYQxyzoojoNnaprNi

def areIsomorphic(a,b):
    if len(a) != len(b):
        return False
    
    
    for i in range(len(a)):
        if len(a[i]) != len(b[i]):
            return False
    
    return True
