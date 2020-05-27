// https://app.codesignal.com/challenge/EBzHMKRnXhoGDP9mG

static int N = 100_000;
static int M = 1_000_000_007;   // modulo
static boolean[] P = new boolean[N+1];  // primes

static {		
    Arrays.fill(P, true);
    P[0] = false;
    P[1] = false;
    for(int i=2; i*i <= N; i++){
        if(!P[i]) continue;
        for(int j=i*i; j <= N; j+=i) P[j] = false;
    }
}

int primesSum2(int n) {
    int s = 0;
    for(int i=0; i <= n; i++) {
        if(!P[i]) continue;
        s = (s%M) + (i%M);
    }

    return s % M;
}

