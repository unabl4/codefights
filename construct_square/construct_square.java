// https://app.codesignal.com/challenge/uHdKEQGKSvNdQhdci

int constructSquare(String s) {
    int L = s.length();
    int A = (int)Math.sqrt(Math.pow(10, (L-1)));    // min square
    int B = (int)Math.sqrt(Math.pow(10, L));        // max square

    int[] targetFormat = extractSignature(s);

    for(int i=B; i >= A; i--) {
        int v = (int) Math.pow(i,2);
        if(conformsToFormat(targetFormat, v)) return v;
    }

    return -1;  // not possible
}

boolean conformsToFormat(int[] targetFormat, int n) {
    String ns = Integer.toString(n);
    return Arrays.equals(targetFormat, extractSignature(ns));
}

// 'zzz' -> [3]
// 'aaa' -> [3]
// 'aab' -> [2,1]
int[] extractSignature(String s) {
    Map<Character, Integer> m = new HashMap<>();
    for(char c: s.toCharArray()) m.put(c, m.getOrDefault(c,0)+1);
    int[] arr = m.values().stream().mapToInt(j->j).toArray();
    Arrays.sort(arr);
    return arr;
}
