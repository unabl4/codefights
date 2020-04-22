// https://app.codesignal.com/challenge/CSApNX3qpJdeeSqYg

String[] repeatedDNASequences(String s) {
    int L = s.length();
    HashMap<String, Integer> h = new HashMap<>();
    
    StringBuilder sb = new StringBuilder(s);
    for(int i=0, j=i+9; i < L && j < L; i++,j=i+9) {
        String str = sb.substring(i,j+1);
        h.put(str, h.getOrDefault(str,0)+1);
    }

    return h.entrySet().stream().filter(i -> i.getValue() > 1).map(i -> i.getKey()).sorted().toArray(String[]::new);
}

