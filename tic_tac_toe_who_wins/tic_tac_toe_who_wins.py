# https://app.codesignal.com/challenge/sqoxMxgWEannMAZgz

g = eval(dir()[0])[0]
c = list(zip(*g)) # columns
d = [[g[i][abs(y-i)] for i in (0,1,2)] for y in (0,2)] # diagonals

m=9 # game numbers are from 0 to 8 => denote 9 as a draw
for l in g+c+d: # lines
    v=map(lambda x: int(x)%2, l)
    if len(set(v)) == 1:
        # all numbers in the line are either even or odd -> win condition obtained
        m = min(m, max(map(int,l)))

if m >= 9:
    return 'draw'
else:
    return 'O' if m % 2 else 'X'
