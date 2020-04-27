// https://app.codesignal.com/challenge/x33p5fg4AsDL9Z9J8

int maxPairProduct(int[] a) {
    int L = a.length;
    Arrays.sort(a); // ?

    Set<Integer> numbers = new HashSet<>();
    Set<Integer> seenNumbers = new HashSet<>();
    int maxN = a[L-1];  // last
    int maxProduct = -1;

    for(int i: a) numbers.add(i);

    for(int i=0; i < L; i++) {
        if(seenNumbers.contains(a[i])) continue;

        for(int j=i+1; j < L; j++) {
            int p = a[i] * a[j];
            if(p > maxN) break;

            if(numbers.contains(p)) maxProduct = Math.max(p, maxProduct);
        }

        seenNumbers.add(a[i]);
    }

    return maxProduct;
}

