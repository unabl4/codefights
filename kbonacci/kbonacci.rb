# https://codefights.com/challenge/sbbmjCsPhn77Qkqtm

def kbonacci(k,n)
    # simplification
    return '1' if n < k 
    return n.to_s if n == k
    
    # hereafter, n > k
    stack = [1] * k
    stack << k
    sum = k # tmp sum
    i = 1 # start index
    # 'e' - end index
    while (e=i+k-1) < n
        sum = sum-stack[i-1]+stack[e]
        stack << sum
        i += 1 # move 1 right
    end
    
    stack[e].to_s
end

