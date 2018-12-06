# https://app.codesignal.com/challenge/unNteEzHcKKDsdjtq

# and I am still clueless what am I doing :)
# still fun, though
w = 'C D EF G A B'

# note -> numeric idx
def num(note):
    i = w.index(note[0])
    if '#' in note:
        i += 1 # sharp -> 1 semitone higher
    
    i += (len(w)*(int(note[-1])-1))
    return i

# 2,2,1,2,2,2,1 (2 - full tone, 1 - semitone)
def majorOrMinor(scale):
    z = zip(scale[:-1], scale[1:])
    d = [num(b)-num(a) for a,b in z] # distances
    return "major" if d == [2,2,1,2,2,2,1] else "minor"
