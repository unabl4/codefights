// https://app.codesignal.com/challenges/page/1

int[] sortByHeight(int[] a) {
    int n = a.length;
    Set<Integer> s = new HashSet<>();  // queue of tree indices
    int[] r = new int[n]; // response

    // register trees' indicies
    for(int i=0; i < n; i++) if(a[i] == -1) s.add(i);
    
    Arrays.sort(a); // O(N*log(N))
    for(int i: s) r[i] = -1;    // fill with trees

    int j=0;
    for(int i=0; i < n; i++) {
        if(s.contains(i)) continue;
        
        while(j+1 < n && a[j] == -1) j++; // move next
        r[i] = a[j];
        j++;
    }

    return r;
}

