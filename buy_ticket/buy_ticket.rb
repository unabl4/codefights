# https://codefights.com/challenge/3PxxRAT5q2ENnjjyR

# Explanation
# There's at most "n-a" locations, so this is why the "min" function.
# At the same time there are at least "b+1" locations that are no over "b"

def buyTicket n,a,b
    [n-a, b+1].min
end
