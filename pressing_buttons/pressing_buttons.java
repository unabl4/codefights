// https://app.codesignal.com/challenge/67WSEJXxvbfSRwbXf

// mapping
String[] M = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

List<String> pressingButtons(String buttons) {
    int n = buttons.length();   // number of buttons pressed (buckets)
    int[] v = new int[n];   // 0-vector
    List<String> r = new ArrayList<String>();   // output

    // map from 'bucket' index to M-index
    Map<Integer, Integer> u = new HashMap<>();
    for(int i=0; i < n; i++) {
        int j = Character.getNumericValue(buttons.charAt(i));   // char number -> int
        u.put(i, j-2);
    }

    while(n > 0) {  // IF
        // 1) 'print'
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < n; i++) sb.append(M[u.get(i)].charAt(v[i]));    // loop through buttons
        
        r.add(sb.toString());

        // 2) increment
        v[n-1]++;   // always increment the last 'bucket' index value
        
        // apply 'corrections' if needed
        for(int i=n-1; i > 0 && v[i] >= M[u.get(i)].length(); i--) {  // buttons
            v[i] = 0;   // reset the current bucket
            if(i-1 >= 0) v[i-1]++;  // increment the previous bucket (if possible)
        }

        // stop condition (no more space to increment)
        if(v[0] >= M[u.get(0)].length()) break;
    }

    return r;
}
