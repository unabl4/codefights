// https://app.codesignal.com/challenge/cXEwQ5xiLjkaDG3Kw

int[] nearestGreater(int[] a) {
    int n = a.length;
    int[] b = new int[n];

    for(int i=0; i < n; i++) {
        int index = -1;
        int T = a[i]; // target

        // we "spread" left and right until we either find a match OR we have nowhere to go
        for(int j=1; j < n; j++) {
            int L = i-j;    // left index
            int R = i+j;    // right index

            if(L >= 0 && R < n) {
                // both valid -> choose
                if(a[L] <= T && a[R] <= T) continue;    // nothing to choose from -> try next pair

                if(a[L] > T && a[R] > T) {
                    index = L;  // ?
                } else if(a[L] > T) {   // a[R] <= T
                    // left
                    index = L;
                } else {    // a[L] <= T
                    // right
                    index = R;
                }

                break;
            } else if(L >= 0) {
                // only left is valid, right is "out of bounds"
                if(a[L] > T) {
                    index = L;
                    break;
                }
            } else if(R < n) { 
                // only right is valid, left is "out of bounds"
                if(a[R] > T) {
                    index = R;
                    break;
                }
            } else {
                // both left and right are "out of bounds" -> nowhere to go anymore; stop
                break;
            }
        }

        b[i] = index;   // record the value
    }

    return b;
}

