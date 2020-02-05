// https://app.codesignal.com/challenge/bSbiYfA43DLCabtoZ

// # - black, '.' - white

boolean correctNonogram(int s, String[][] f) {    
    return check(s,f,"r") && check(s,f,"c");
}

boolean check(int s, String[][] f, String axis) {
    int u = f.length;
    int n = u-s; // starting index
    
    for(int y=n; y < u; y++) {
        StringBuilder sb = new StringBuilder(); // grid string 
        List<String> d = new ArrayList<>();
        
        for(int x=0; x < u; x++) {  // square
            String e = axis.equals("r") ? f[y][x] : f[x][y];    // grid element
            
            if(x < n && !e.equals("-")) {
                d.add(e); // number of repetitions
            } else if(x >= n) {
                // the paint area
                sb.append(e);
            }
        }
        
        // ---
        
        StringBuilder psb = new StringBuilder();    // pattern
        if(d.isEmpty()) {
            psb.append("\\.*");
        } else {
            psb.append("\\.*");
            for(int i=0; i < d.size(); i++) {
                psb.append("#{"+d.get(i)+"}");  // '#' exactly d[i] times
                if(i < d.size()-1) psb.append("\\.{1,}"); // one or more times
            }
            psb.append("\\.*");
        }
        
        Pattern p = Pattern.compile("^" + psb.toString() + "$");
        Matcher m = p.matcher(sb.toString());
        if(!m.matches()) return false;
    }
    
    return true;    // valid
}
