def remainderSum x,y
    return -1 if x == 0 || y == 0
    a = x % y
    b = y % x
    [a,b].map(&:abs).sum
end
