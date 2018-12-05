# https://app.codesignal.com/challenge/C82o9dbM6sYPFHd7p

# I have ABSOLUTELY zero clues what am I doing ... O_o Honestly
z = 'eBGDAE'
m = {
    'E2':  (0,5),
    'F2':  (1,5),
    'F#2': (2,5),
    'G2':  (3,5),
    'G#2': (4,5),
    'A2':  (0,4),
    'A#2': (1,4),
    'B2':  (2,4),
    'C3':  (3,4),
    'C#3': (4,4),
    'D3':  (0,3),
    'D#3': (1,3),
    'E3':  (2,3),
    'F3':  (3,3),
    'F#3': (4,3),
    'G3':  (0,2),
    'G#3': (1,2),
    'A3':  (2,2),
    'A#3': (3,2),
    'B3':  (0,1),
    'C4':  (1,1),
    'C#4': (2,1),
    'D4':  (3,1),
    'D#4': (4,1),
    'E4':  (0,0),
    'F4':  (1,0),
    'F#4': (2,0),
    'G4':  (3,0),
    'G#4': (4,0),
    'A4':  (5,0),
} # mapping (lowest fret first)

def simpleASCIIGuitarTab(notes):
    t = notes.split(' ') # timeline
    n = len(t)
    l = n + (n-1) + 2 # total length (string length)
    w = len(z) # rows
    g = [[-1 for _ in range(l)] for _ in range(w)] # '-1' = space

    for i in range(n):
        f,b = m[t[i]]
        x = 2*i+1 # always odd index (due to spaces): 1,3,5, ... inf
        g[b][x] = f
        
    o = [''] * w # output
    for i in range(w):
        r = ['-' if y == -1 else str(y) for y in g[i]] # row
        o[i] = ''.join([z[i], ' |', ''.join(r), '|'])
    return o
