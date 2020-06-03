// https://app.codesignal.com/challenge/wTZeJ7vBBRMBw9Rc5

List<List<Integer>> nQueens(int n) {
    List<List<Integer>> seqs = new ArrayList<>();
    nQueens(1, n, null, seqs);
    return seqs;
}

void nQueens(int k, int n, List<Integer> seq, List<List<Integer>> seqs) {   
    for(int i=1; i <= n; i++) { 
        if(!canPlace(k,i,seq)) continue; 
        
        List<Integer> newSeq = (seq == null) ? new ArrayList<>() : new ArrayList<>(seq);    // new or copy             
        newSeq.add(i);
        
        if(k == n) { // last column reached? -> placing done
            seqs.add(newSeq);   // record the placing sequence
        } else {
            nQueens(k+1, n, newSeq, seqs);    // place the next queen
        } 
    }
}

boolean canPlace(int k, int i, List<Integer> seq) {
    if(seq == null) return true;    // nothing has been placed yet -> always possible
    
    for(int j=1; j < k; j++) {
        int r = seq.get(j-1);   // row number
        if(r == i || Math.abs(r-i) == Math.abs(j-k)) return false;
    }
    
    return true;
}
