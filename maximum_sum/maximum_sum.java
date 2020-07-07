// https://app.codesignal.com/challenge/J4Xgc6n2R9NuyLmNM

int maximumSum(int[] a, int[][] q) {
    int s = 0;
    int N = a.length;
    int[] V = new int[N];
    
    Arrays.sort(a); // asc (even though desc is needed)
    Map<Integer, Integer> m = new HashMap<>();
    
    for(int[] Q: q) {   // queries
        for(int i=Q[0]; i <= Q[1]; i++) {
            m.put(i, m.getOrDefault(i,0)+1);
        }
    }
    
    V = m.values().stream().sorted(Comparator.reverseOrder()).mapToInt(i->i).toArray();
    
    for(int i=0; i < V.length; i++) s += (a[N-1-i] * V[i]);    
    return s;
}

