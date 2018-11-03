# https://app.codesignal.com/challenge/iFMNmfhhwadSaRtpX

t,p,s,j = eval(dir()[0])
if len(t) <= 0:
    return 0

p = set(p)
s = set(s)

# prefix sum
ps = [0] * (len(t)+1)
ps[1] = t[0]
for y in range(1,len(t)):
    ps[y+1] = ps[y]+t[y]
    
# main loop
x = 0    
while x < len(ps):
    # find the furthest we can jump
    y = x
    while y+1 < len(ps):
        if ps[y+1]-ps[x] > j:
            break # no point looking any further
        y += 1
        
    if x == y:
        # we could not jump any higher (or it is the end)
        break
        
    x = y # goto
    if x-1 in p:
        j += 1
    
    if x-1 in s:
        j -= 1
    
return ps[x]
