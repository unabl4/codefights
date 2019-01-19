# https://app.codesignal.com/challenge/qBciCnWsCqNKTeLRP

def most_freq(nums):
    f = {} # freq
    for num in nums:
        for i in num:
            f[i] = f.get(i,0)+1
    
    if len(set(f.values())) == 1:
        # all the values are the same -> ?
        return "?"
    
    return max(f,key=lambda x:f[x])

def pinPadDiscovery(logins):
    v = [most_freq(i) for i in list(zip(*logins))]
    return ''.join(v)
