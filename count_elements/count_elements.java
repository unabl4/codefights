// https://app.codesignal.com/challenge/K6E2EcSFb9uDW3gng

int countElements(String I) {
    int c = 0;  // counter
    int n = I.length();
    
    for(int i=0; i < n; i++) {
        int ch = I.charAt(i);
        
        if(ch == '"') {
            // opening
            c++;
            
            System.out.println(i);
            
            // closing
            while(i+1 < n && I.charAt(i+1) != '"') i++;
            i++;
        } else if(Character.isDigit(ch)) {
            c++;
            
            System.out.println(i);
            // closing
            while(i+1 < n && Character.isDigit(I.charAt(i+1))) i++;
            i++;
        } else {
            // true, false
            
            if(i+3 < n && I.substring(i, i+4).equals("true")) {
                c++;
                i+=4;
            }
            
            if(i+4 < n && I.substring(i, i+5).equals("false")) {
                c++;
                i+=5;
            }
        }
    }    
    
    return c;
}

