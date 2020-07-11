// https://app.codesignal.com/challenge/nKCsxcFANWzXTtwDb

Map<Integer, Integer> m = new HashMap<>();

int climbingStairs(int n) {
    if(n < 0) return 0;
    if(n == 0) return 1;
    
    // memo
    if(m.containsKey(n)) return m.get(n);
    
    int v = climbingStairs(n-1) + climbingStairs(n-2);
    m.put(n, v);
    
    return v;
}
