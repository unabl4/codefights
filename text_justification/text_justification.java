// https://app.codesignal.com/challenge/eTP8Sis7X93E6m25t

List<String> textJustification(String[] w, int l) {
    int n = w.length;   // number of words
    List<String> r = new ArrayList<>();
    // projected line length: (Σ |Wi|) + (j-i+1-1), where j >= i

    // indices
    int i = 0;
    int j = 0;

    while(j < n) {
        StringBuilder sb = new StringBuilder();
        int t = w[i].length();    // we can always select the very first word from the list
        while(j+1 < n && (t + w[j+1].length() + (j+1-i) <= l)) {
            t += w[j+1].length();   // select the next word
            j++;    // move next
        }

        int spaceSlack = l-t;   // number of spaces to be put
        for(int x=i; x <= j; x++) {           
            // 1) append the word 
            sb.append(w[x]); 

            // 2) arrange spaces
            // single-line word or the last line (or both)
            if(i == j || j >= n-1) {
                if(x == j) {    // last word reached?
                    for(int u=0; u < spaceSlack; u++) sb.append(" ");    // add space;
                } else {
                    // not the last word -> use regular singular spaces
                    sb.append(" ");
                    spaceSlack--;
                }
            } else {
                int v = (int)Math.ceil((double)spaceSlack / (j-x));
                for(int u=0; u < v; u++) sb.append(" ");    // add spaces;
                spaceSlack -= v;
            }
        }
        // the line is ready
        r.add(sb.toString());   // add the line
        i = ++j;
    }

    return r;
}

