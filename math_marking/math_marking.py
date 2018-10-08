# https://app.codesignal.com/challenge/TkvsWkCmZea5p5XB3

def mathMarking(s):
    v = [eval(e) for e in s.split("=")]
    z = sum(x == y for x,y in zip(v[:-1], v[1:]))   # each_cons(2)
    return "%d / %d" % (z,len(v)-1)
