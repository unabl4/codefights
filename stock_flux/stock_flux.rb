# https://app.codesignal.com/challenge/jiLk3Wj4oiiEDHfgt

def stockFlux p
    (p.reduce(1) { |a,x| a *= 1+x/100 }-1)*100
end
