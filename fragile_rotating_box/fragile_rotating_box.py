# https://app.codesignal.com/challenge/s6yCyg62daz3xpCou

b,r=eval(dir()[0])
# compute box states
z = [0]*4
z[0] = b # initial box edge
for i in range(3):
    z[i+1] = list(zip(*z[i][::-1]))

s=0 # sum
i=0 # box state index
j=0 # surface offset
while j < len(r):
    g = z[i][-1] # current box edge
    l = len(g) # length of the box edge        
    s += sum(int(a)*int(b) for a,b in zip(g,list(r[j:j+l])))
    j += l
    i = (i+1)%4 # roll the box
return s
