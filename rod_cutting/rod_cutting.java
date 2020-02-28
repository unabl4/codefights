// https://app.codesignal.com/challenge/AHL2v6hReiaHhZCJR

// DP is not my strongest side
int rodCutting(int n, int[] v) {
    Map<Integer, Integer> h = new HashMap<>();    // cache
    int dp = DP(n,v,h);
    // System.out.println(h);
    return dp;
}

int DP(int n, int[] v, Map<Integer, Integer> h) {
    if(h.containsKey(n)) {
        return h.get(n);
    }

    // base case
    if(n <= 0) return 0;    // nothing else to cut
    
    int M = 0;  // max
    for(int i=1; i <= n; i++) {
        M = Math.max(M, v[i]+DP(n-i,v,h));
    }

    h.put(n,M); // memoize
    return M;
}
