# https://app.codesignal.com/challenge/dzPQ2HKpmv8dNqfNn

import re
r = re.compile(r"^([a-g](?:f|s?))\d?$") # not sure about the number part
# r = re.compile(r"([a-g](?:f|s?))\d$")

# key vectors
# c|cs/df|d|ds/ef|e|f|fs/gf|g|gs/af|a|as/bf|b  (len=12 bits)

kv = {'c':0,'cs':1,'df':1,'d':2,'ds':3,'ef':3,'e':4,'f':5,'fs':6,'gf':6,'g':7,'gs':8,'af':8,'a':9,'as':10,'bf':10,'b':11} # 0..11

# keys to notes mapping (the table from the description)
keys = [
    0b010110101011,
    0b010101101011,
    0b110101101010,
    0b110101011010,
    0b101101011010,
    0b101101010110,
    0b101011010110,
    0b101011010101,
    0b101010110101,
    0b011010110101,
    0b011010101101,
    0b010110101101,
]

def whatKeyCouldItBe(pattern):
    # part 1: extract all the notes (without octaves)
    # replace all the weird characters with spaces (to split by later)
    # the most difficult part of the challenge, actually
    
    s = pattern.lower()
    c = "[[]]*/~,()" # chars to be removed (replaced by spaces first)
    tr = str.maketrans(c, " " * len(c))
    note_string = s.translate(tr)
    raw_notes = [i for i in note_string.split() if not i.isspace()]
    notes = [m.groups()[0] for m in [r.match(i) for i in raw_notes] if m]
    notes = set(notes) # remove possible duplicates
    
    # part 2: prepare the 'query' vector
    q = 0
    for note in notes:
        q |= (1 << (11-kv[note])) # raise the corresponding bit
    
    # part 3: lookup through the note vectors
    return [i+1 for i in range(12) if keys[i] & q == q]
