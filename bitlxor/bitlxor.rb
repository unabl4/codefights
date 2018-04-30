# https://codefights.com/challenge/AHxX6e3fQd5cv23q7

def bitLXor(a,b)
    # get bit length
    x,y = [a,b].map { |t| t.abs.to_s(2).size }
    z = [x,y].max # 'common' len
    (a << (z-x)) ^ (b << (z-y)) # 'align' and xor
end
