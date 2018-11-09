# https://app.codesignal.com/challenge/cuXxKCwGdY58hRTf2

# ugly ass solution, lazy to compress it.
t = {
    0: 'a',
    9: 'e',
    8: 'i',
    7: 'o',
    6: 'u',
    5: 'y',
    4: 'w',
    10: 't',
    11: 'd',
    12: 's',
    13: 'n',
    14: 'm',
    15: 'r',
    16: 'b',
    17: 'k',
    18: 'p',
    '*': 'morning',
    '@':'afternoon',
    '#':'night',
    '?': '-',
}

def decision(day, time, location):
    if day == "today":
        return location == "park"
    elif day == "tomorrow":
        return (time == "night" and location == "bar") or (time == "afternoon" and location == "park")
    else:
        return time == "morning" and location == "restaurant"

# ---

m,d = eval(dir()[0])
g=[x for x in m.split('.')]
o = 0 # diff offset
i = 0
y = []
z = []
for i,c in enumerate(g):
    if c == '_':
        o += d
    else:
        v = t[int(c)+o] if c.lstrip('-').isdigit() else t[c]
        if not c == '?':
            z.append(v)
    
    if c == '?' or i == len(g)-1:
        y.append(''.join(z))
        z = [] # reset
    
om = '-'.join(y)
return [om, "5.9.12" if decision(*y) else "13.7"]
