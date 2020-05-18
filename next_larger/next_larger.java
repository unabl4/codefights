// https://app.codesignal.com/challenge/vJvtwE6LRfy3PbPQZ

// start in O(n^2)
int[] nextLarger(int[] a) {
    int n = a.length;
    int[] R = new int[n];

    for(int i=0; i < n; i++) {
        int v = -1;

        for(int j=i+1; j < n; j++) {
            if(a[j] > a[i]) {
                v = a[j];
                break;  // stop
            }
        }

        R[i] = v;
    }

    return R;
}

