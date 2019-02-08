# https://app.codesignal.com/challenge/diFFHsGg27MQkh2DD

# too lazy to optimize it
l = 21
t = [[j*i for j in range(1,l)] for i in range(1,l)]

def differentValuesInMultiplicationTable(n, m):
    s = set()
    for x in range(n):
        for y in range(m):
            s.add(t[x][y])
    
    return len(s)
