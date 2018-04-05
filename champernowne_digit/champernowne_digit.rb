# https://codefights.com/challenge/qw45pMspPFfuPpcEQ

def champernowneDigit n
    i = 1
    c = "1"
    c << (i+=1).to_s while c.size < n
    c[n-1].to_i
end
