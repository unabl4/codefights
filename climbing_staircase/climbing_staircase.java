// https://app.codesignal.com/challenge/GDREYpfM8SsevYQsP

List<List<Integer>> climbingStaircase(int n, int k) {    
    List<List<Integer>> L = new ArrayList<>();
    
    if(n == 0 || k == 0) {
        L.add(new ArrayList<>());
        return L;
    }
    
    climb(L, null, n, k);
    return L;
}

void climb(List<List<Integer>> L, List<Integer> M, int n, int k) {
    if(n < 0) return;
    
    if(n == 0) {
        L.add(M);
        return; // stop
    } 
    
    for(int i=1; i <= k; i++) {
        if(n-i < 0) break;  // shortcut
        
        List<Integer> P = M == null ? new ArrayList() : new ArrayList<>(M);
        P.add(i);
        climb(L, P, n-i, k);
    }
}
