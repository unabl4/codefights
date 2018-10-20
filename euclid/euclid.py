# https://app.codesignal.com/challenge/sGCDg7j85nTYF7ceS

from math import sin, cos, acos

# distance between two points
def distance(p1, p2):
    return ((p2[0]-p1[0])**2+(p2[1]-p1[1])**2)**0.5

def euclid(c):
    A,B,C,D,E,F = [(c[i],c[i+1]) for i in range(0,len(c),2)] # form pairs into points
    # print(A,B,C,D,E,F)
    # part 1: triangle area 
    # https://en.wikipedia.org/wiki/Heron%27s_formula
    DE=distance(D,E)
    EF=distance(E,F)
    DF=distance(D,F)
    s = (DE+EF+DF) / 2 # semi-perimeter
    a = (s*(s-DE)*(s-EF)*(s-DF))**0.5 # triangle area
    # print(a)
    
    # part 2
    AB = distance(A,B)
    AC = distance(A,C)
    # print(AB, AC)

    # ---
    
    vAB=(B[0]-A[0], B[1]-A[1])
    vAC=(C[0]-A[0], C[1]-A[1])
    
    # get the angle between the two vectors
    angle = acos(abs(vAB[0]*vAC[0]+vAB[1]*vAC[1]) / AB / AC) # rads
    # print(angle)
    
    L=a/AB/sin(angle) # len
    vACn = tuple(map(lambda x: L*x/AC, vAC)) # unit vector
    # print(vACn)
    points = [map(lambda f: round(f[1]+vACn[f[0]],3), enumerate(z)) for z in [B,A]]
    return [i for s in points for i in s] # flatten
