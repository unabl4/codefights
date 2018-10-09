# https://app.codesignal.com/challenge/cnZy77mSR8fTZsTqf

import re

z = re.compile('(.*) \$(\d+)')
def greedySupplyGigs(offers):
    r = {}
    a = {}
    total = 0
    for os in offers:
        m = set()
        mp = 0
        ss = None
        for o in os:
            s,p = z.match(o).groups()
            m.add(s)
            if r.get(s,0) <= a.get(s,0)/2 and int(p) > mp:
                ss = s
                mp = int(p)
        
        if ss:
            a[ss] = a.get(ss,0)+1
            for ots in m:
                if ots != ss:
                    r[ots] = r.get(ots,0)+1
        
        total += mp
        
    return total   
