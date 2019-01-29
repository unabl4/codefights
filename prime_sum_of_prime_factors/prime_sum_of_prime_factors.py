# https://app.codesignal.com/challenge/rGhmwd7wpHyTK6v8a

L=int(1e5) # upper limit

def prime_factors(n,P):
    f = [] # factors
    for prime in P:
        # while n is divisible keep adding the prime
        while n % prime == 0:
            f.append(prime)
            # update n by dividing by the prime
            n //= prime
    if n > 1:
        f.append(n)
    return f

# prime generator (sieve)
def primes(L):
    a = [1] * L
    a[0] = a[1] = False # 0 and 1 are NOT primes

    for (i, is_prime) in enumerate(a):
        if not is_prime:
            continue
        for n in range(i*i, L, i):
            a[n] = False
        
    p = set()
    for i in range(L):
        if a[i]:
            p.add(i)
    
    return p

# ===

def primeSumOfPrimeFactors(n):
    p = primes(L) # generate the list of primes
    f = sum(prime_factors(n,p))
    return f in p
