# https://app.codesignal.com/challenge/Kmnmxainrp7JmY7wB

# pre-generate the list
L=list(range(1, 10_000+1))
j=2
while j <= len(L):
    L=[L[i] for i in range(len(L)) if (i+1)%j>0]
    j+=1

# ---
    
def flaviusJosephus(n):
    return L[n-1]
