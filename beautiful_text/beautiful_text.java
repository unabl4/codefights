// https://app.codesignal.com/challenge/yfcbMAv56vHco2rue

boolean beautifulText(String S, int L, int R) {
    int N = S.length()-1; // last index
    
    for(int i=L; i <= R; i++) {
        int currentIndex = 0;
        int indexWidth = i-1;
        
        
        while(true) {        
            currentIndex += indexWidth;
            if(currentIndex > N) break;
            if(currentIndex == N) return true;  // end of the sentence reached -> true
            
            currentIndex++;
            if(S.charAt(currentIndex) != ' ') break;
            currentIndex++;
        }
    }
    
    return false;
}
