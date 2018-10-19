# https://app.codesignal.com/challenge/PiZD5R2h2Nrdr2ePh

A,B,C,D=eval(dir()[0])
g=c=0
for i in range(len(A)):
    a=set([A[i],B[i]])
    b=set([C[i],D[i]])
    if a != b:
        return -1

    if A[i] != C[i]:
        g += 1
    elif g > 0:
        c += 1
        g = 0
        
    if g >= 3:
        g = 0
        c += 1
    
if g > 0:
    c += 1
    
return c
