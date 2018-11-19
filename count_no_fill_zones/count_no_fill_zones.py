# https://app.codesignal.com/challenge/sEQJmYPDMryEsXKhQ

# lazy to golf, sorry :)
m = {
    'a': 1,
    'b': 1,
    'd': 1,
    'e': 1,
    'g': 1,
    'o': 1,
    'p': 1,
    'q': 1,
    'B': 2,
    'E': 0,
    'G': 0,
    'R': 1,
    '0': 1,
    '4': 1,
    '6': 1,
    '8': 2,
    '9': 1,
}

# a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
# A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z

def countNoFillZones(w):
    return sum(m.get(c, m.get(c.lower(),0)) for c in w)
