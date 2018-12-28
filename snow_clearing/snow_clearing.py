# https://app.codesignal.com/challenge/NzsCrgiv84xKj56DK

MAX = 100001 # max index
def snowClearing(queries):
    s = 0 # total sum
    nz_indices = set([MAX]) # non-zero, 10^5+1
    v = [0] * (MAX+1)
    v[MAX] = 1
    for query in queries:
        if query[0] == 1:
            # insert
            v[query[1]] += query[2]
            if v[query[1]] != 0: # non-zero?
                nz_indices.add(query[1])
            elif query[1] in nz_indices:
                nz_indices.remove(query[1])
        elif query[0] == 0:
            j = -1
            for i in nz_indices:
                if i >= query[1] and v[i] != 0 and (j == -1 or i < j):
                    j = i
            
            # assert j != -1
            s += j
                    
    return s
