# https://app.codesignal.com/challenges

from math import gcd

def fractionSum(a,b):
    d = a[1]*b[1] # common denominator
    n = d / a[1] * a[0] + d / b[1] * b[0] # new nominator
    v = [int(i) for i in [n,d]] # pre-final value(s)
    r = gcd(*v)
    return [i/r for i in v]
