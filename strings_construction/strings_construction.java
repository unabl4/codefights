// https://app.codesignal.com/challenge/aPrGds9tYnZkYFQkG

int stringsConstruction(String a, String b) {
    Map<Character, Integer> A = new HashMap<>();
    Map<Character, Integer> B = new HashMap<>();
    
    for(char c: a.toCharArray()) A.put(c, A.getOrDefault(c,0)+1);
    for(char c: b.toCharArray()) B.put(c, B.getOrDefault(c,0)+1);
    
    Integer M = null;   // min
    
    for(char c: a.toCharArray()) {
        int u = A.get(c);
        int v = B.getOrDefault(c,0);
        
        if(M == null) {
            M = v/u;
        } else {
            M = Math.min(M, v/u);
        }
    }
    
    return M;
}

