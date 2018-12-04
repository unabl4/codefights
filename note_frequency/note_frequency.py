# https://app.codesignal.com/challenge/cWB64385L6Fe6zD4D

def noteFrequency(note):
    # we will assume that invalid notes will NOT be used
    
    w = 'C D EF G A B' # full list of notes
    s = 0 # shift (sharp/flat)
    
    n,o = note[0], int(note[-1]) # note/octave
    if len(note) == 3:
        s = 1 if note[1] == '#' else -1
    
    i = w.index(n)+s
    f = 440 * 2 ** ((i-9)/12) * (2 ** (o-4)) # 440 Hz = A4
    return f
