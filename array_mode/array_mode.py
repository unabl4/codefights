# https://app.codesignal.com/challenge/J6DuW9RqENKaJjkGS

def arrayMode(S):
    f = {}
    for n in S:
        f[n] = f.get(n,0)+1
    
    return max(S,key=lambda i:f[i])
