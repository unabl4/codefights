// https://app.codesignal.com/challenge/yX8juso8PLkgtPvBw

int mostFrequentDigitSum(int n) {
    Map<Integer, Integer> h = new HashMap<>();
    h.put(sumOfDigits(n), 1);    // the number itself

    int maxOccurrence = 1;
    int maxValue = 0;

    while(n > 0) {
        int S = sumOfDigits(n);
        int T = sumOfDigits(n-S);
        n -= S;

        h.put(T, h.getOrDefault(T,0)+1);
    }

    for(Map.Entry<Integer,Integer> e: h.entrySet()) {
        int k = e.getKey();
        int v = e.getValue();

        if(v > maxOccurrence || (v == maxOccurrence && k > maxValue)) {
            maxValue = k;
            maxOccurrence = v;
        }
    }

    return maxValue;
}

// sum of digits
int sumOfDigits(int n) {
    int L = (int)(Math.floor(Math.log10(n))+1);
    int S = 0;

    while(L > 0) {
        int p = (int)Math.pow(10, L-1);
        S += n / p;
        n %= p;
        L--;
    }

    return S;
}
