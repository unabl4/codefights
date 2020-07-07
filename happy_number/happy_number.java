// https://app.codesignal.com/challenge/cyDPaP4tuzgJnqTDb

boolean happyNumber(int n) {
    Set<Integer> S = new HashSet<>();
    
    while(true) {
       n = sumOfSquares(n);
       if(n == 1) return true;  // happy path  
       
       if(S.contains(n)) return false;  // loop detected
       S.add(n);
    }
}

int sumOfSquares(int n) {
    int L = (int)(Math.floor(Math.log10(n))+1);
    int s = 0;
    
    while(L > 0) {
        int p = (int)(Math.pow(10, L-1));
        int d = (n / p);
        s += d * d; // square of digits
        n %= p;
        L--;
    }
    
    return s;
}
