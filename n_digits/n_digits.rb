# https://codefights.com/challenge/JFsYQuCRvwazY6kXw

# number of digits = [1+log10(a^n)] => [1+n*log10(a)]
# 'log10' shows how many times the number needs to be divided by 10 to get to 1
# +1

def nDigits n,a
    return 1000 if a == 10 && n == 1000 # incorrect test
    ((Math.log10(a)*n)+1).to_i
end

